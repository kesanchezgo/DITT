import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-participant-registration',
  templateUrl: './participant-registration.page.html',
  styleUrls: ['./participant-registration.page.scss'],
})
export class ParticipantRegistrationPage implements OnInit {

  firstName: string = '';
  lastName: string = '';
  middleName: string = '';
  verificationCode: string = '';
  address: string = '';
  phone: string = '';
  birthDate: string = '';
  email: string = '';
  password: string = '';

  constructor(
    private authService: AuthenticationService,
    private alertController: AlertController
  ) {}

  async presentAlert(message: string) {
    const alert = await this.alertController.create({
      header: 'Message',
      message: message,
      buttons: ['Accept'],
    });

    await alert.present();
  }

  ngOnInit() {
  }

  register() {
    // Check if all required fields are provided
    if (
      this.firstName &&
      this.lastName &&
      this.middleName &&
      this.verificationCode &&
      this.address &&
      this.phone &&
      this.birthDate &&
      this.email &&
      this.password
    ) {
      // Call the registration function from the service
      this.authService
        .register(
          this.firstName,
          this.lastName,
          this.middleName,
          this.verificationCode,
          this.address,
          this.phone,
          this.birthDate,
          this.email,
          this.password
        )
        .subscribe(
          (response) => {
            // Registration successful, you can redirect the user to the login page or take some other action.
            this.presentAlert('Registration successful.');
          },
          (error) => {
            // Handle registration errors (e.g., duplicate email)
            console.error('Registration error:', error);
            this.presentAlert('Registration error:' + error.error.message);
            // You can display an error message to the user if needed
          }
        );
    } else {
      // Handle the case where the user didn't provide all required fields
      console.error('Please complete all fields.');
      this.presentAlert('Please complete all fields.');
      // You can display a validation message to the user if needed
    }
  }
}
