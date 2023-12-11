import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-dni-scanner',
  templateUrl: './dni-scanner.page.html',
  styleUrls: ['./dni-scanner.page.scss'],
})
export class DniScannerPage implements OnInit {

  constructor(private navCtrl: NavController) { }

  ngOnInit() {
  }

  // Función para ir atrás
  goBack() {
    this.navCtrl.back(); // Esta función regresa a la página anterior
  }

}
