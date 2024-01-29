import { Component } from '@angular/core';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  constructor() {}

  // ... otros métodos y propiedades

  registrarEntrada() {
    // Lógica para registrar entrada
    console.log('Entrada registrada');
  }

  registrarSalida() {
    // Lógica para registrar salida
    console.log('Salida registrada');
  }

}
