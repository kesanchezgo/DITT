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


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage {
  dni: string="";
  password: string="";

  constructor(private authService: AuthenticationService, private router: Router, private alertController: AlertController) {}

  async presentAlert(message: string) {
    const alert = await this.alertController.create({
      header: 'Mensaje',
      message: message,
      buttons: ['Aceptar']
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
          this.presentAlert('Error de autenticación:'+ error.error.message);
          // Puedes mostrar un mensaje de error al usuario si es necesario
        }
      );
    } else {
      // Maneja el caso en que el usuario no haya proporcionado DNI o contraseña
      console.error('Por favor, ingrese DNI y contraseña.');
      this.presentAlert('Por favor, ingrese DNI y contraseña.');
      // Puedes mostrar un mensaje de validación al usuario si es necesario
    }
  }
}
