/* import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

} */


import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { AlertController } from '@ionic/angular';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage {
  dni: string="";
  password: string="";

  constructor(private authService: AuthenticationService, 
              private router: Router, 
              private alertController: AlertController,
              private navCtrl: NavController) {}

  async presentAlert(message: string) {
    const alert = await this.alertController.create({
      header: 'Mensaje',
      message: message,
      buttons: [
        {
          text: 'Aceptar',
          cssClass: 'success-btn', // Aplicar el estilo de color 'success'
        }
      ]
    });
  
    await alert.present();
  }

  login() {
    // Verifica si se proporcionaron el DNI y la contraseña
    if (this.dni && this.password) {
      // Llama a la función de autenticación del servicio
      this.authService.login(this.dni, this.password).subscribe(
        (response) => {
          // Autenticación exitosa, redirige al usuario a su panel de control
          this.router.navigate(['/user-dashboard']);
        },
        (error) => {
          // Maneja errores de autenticación (por ejemplo, credenciales incorrectas)
          console.error('Error de autenticación:', error);

          // Modifica la respuesta de autenticación para permitir el acceso de prueba
          if (this.dni === '99999999' && this.password === 'qwerty') {
            console.log('Acceso de prueba permitido.');
            // Puedes redirigir al usuario a donde desees después de la autenticación de prueba
            this.router.navigate(['/user-dashboard']);
          } else {
            // Si no es una autenticación de prueba, muestra el mensaje de error
            this.presentAlert('Error de autenticación:' + error.error.message);
            // Puedes mostrar un mensaje de error al usuario si es necesario
          }
        }
      );
    } else {
      // Maneja el caso en que el usuario no haya proporcionado DNI o contraseña
      console.error('Por favor, ingrese DNI y contraseña.');
      this.presentAlert('Por favor, ingrese DNI y contraseña.');
      // Puedes mostrar un mensaje de validación al usuario si es necesario
    }
  }

  // Función para ir atrás
  goBack() {
    this.navCtrl.back(); // Esta función regresa a la página anterior
  }

  // Función para recuperar la contraseña
  recoverPassword() {
    // Agrega aquí la lógica para la recuperación de contraseña, como enviar un correo o navegar a otra página.
  }
}
