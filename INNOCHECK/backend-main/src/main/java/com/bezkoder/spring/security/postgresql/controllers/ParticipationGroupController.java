package com.bezkoder.spring.security.postgresql.controllers;
import com.bezkoder.spring.security.postgresql.Objets.InviteRequest;
import com.bezkoder.spring.security.postgresql.models.Invitation;
import com.bezkoder.spring.security.postgresql.models.ParticipationGroup;
import com.bezkoder.spring.security.postgresql.models.Project;
import com.bezkoder.spring.security.postgresql.models.User;
import com.bezkoder.spring.security.postgresql.payload.request.LoginRequest;
import com.bezkoder.spring.security.postgresql.payload.response.JwtResponse;
import com.bezkoder.spring.security.postgresql.payload.response.MessageResponse;
import com.bezkoder.spring.security.postgresql.repository.InvitationRepository;
import com.bezkoder.spring.security.postgresql.repository.ParticipationGroupRepository;
import com.bezkoder.spring.security.postgresql.repository.ProjectRepository;
import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import com.bezkoder.spring.security.postgresql.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/participationgroup")
public class ParticipationGroupController {

    @Autowired
    private ParticipationGroupRepository participationGroupRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InvitationRepository invitationRepository;

    @Autowired
    private EmailService emailService;

    // Crear un nuevo grupo de participación
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> createParticipationGroup(@Valid @RequestBody ParticipationGroup participationGroup) {
        // Asegurarse de que el proyecto y el líder existan
        Optional<Project> project = projectRepository.findById(participationGroup.getProject().getId());
        Optional<User> leader = userRepository.findById(participationGroup.getLeader().getId());

        if (project.isPresent() && leader.isPresent()) {
            participationGroup.setProject(project.get());
            participationGroup.setLeader(leader.get());

            // Guardar el grupo de participación en la base de datos
            participationGroupRepository.save(participationGroup);
            return ResponseEntity.ok(new MessageResponse("Participation group registered successfully!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Project or Leader not found!"));
        }
    }

    //enviar una invitacion a miembro de grupo(participation group), se creo un modelo(tabla) llamado invitacion
    //que almacena un token unico de invitacion acia el usuario , ahora , cuando este token es aceptado en el otro metodo (abajo -aceptar invitacio) se elimina la invitacion porque ya fue usada.
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR')")
    @PostMapping("/invite")
    public ResponseEntity<?> inviteMembers(@Valid @RequestBody InviteRequest inviteRequest) {
        Optional<ParticipationGroup> participationGroupOptional = participationGroupRepository.findById(inviteRequest.getGroupId());
        if (participationGroupOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Group not found."));
        }

        ParticipationGroup participationGroup = participationGroupOptional.get();
        for (String email : inviteRequest.getUserEmails()) {
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // Aquí generarías un token único y lo guardarías en algún lugar para su posterior verificación
                String uniqueToken = UUID.randomUUID().toString();
                // Guardar el token asociado al usuario y al grupo

                Invitation invitation = new Invitation();
                invitation.setUser(user);
                invitation.setGroup(participationGroup);
                invitation.setToken(uniqueToken);
                invitationRepository.save(invitation);

                String inviteLink = "http://yourfrontend.com/accept?token=" + uniqueToken; // Un enlace al frontend donde el usuario puede aceptar la invitación
                String message = "You have been invited to join the group: " + participationGroup.getName() + ". Please click on the following link to accept the invitation: " + inviteLink;
                emailService.sendSimpleMessage(user.getEmail(), "Group Invitation", message);
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: User with email " + email + " not found."));
            }
        }

        return ResponseEntity.ok(new MessageResponse("Invitations sent successfully!"));
    }
    //acepta la invitacion enviada . Elimina la invitacion una vez esta se acepte porque ya se uso el token.
    @PostMapping("/accept-invitation")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> acceptInvitation(@Valid @RequestBody String token) {
        Optional<Invitation> invitationOptional = invitationRepository.findByToken(token);

        if (!invitationOptional.isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Invalid invitation token."));
        }

        Invitation invitation = invitationOptional.get();
        ParticipationGroup group = invitation.getGroup();
        User user = invitation.getUser();

        // Agregar el usuario al grupo de participación
        group.getMembers().add(user);
        participationGroupRepository.save(group);

        // Eliminar la invitación ya que ha sido aceptada
        invitationRepository.delete(invitation);

        return ResponseEntity.ok(new MessageResponse("You have successfully joined the group."));
    }



}