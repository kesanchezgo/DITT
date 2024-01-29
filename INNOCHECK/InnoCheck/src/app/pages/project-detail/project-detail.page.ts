import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.page.html',
  styleUrls: ['./project-detail.page.scss'],
})
export class ProjectDetailPage implements OnInit {
  nombreNuevoIntegrante: string=""; // Asegúrate de agregar esta línea
  selectedSegment: 'project' | 'group' = 'project'; 
  constructor(private navCtrl: NavController) { }

  ngOnInit() {
  }

  proyecto: any = this.generarProyectoAleatorio();

  // Datos de ejemplo para el grupo
  grupo = {
    codigoGrupo: 'G001',
    nombreGrupo: 'Grupo de Proyecto',
    integrantes: [
      { codigoIntegrante: 'I001', nombreIntegrante: 'Integrante 1' },
      { codigoIntegrante: 'I002', nombreIntegrante: 'Integrante 2' },
      { codigoIntegrante: 'I003', nombreIntegrante: 'Integrante 3' },
    ]
  };

  // Función para generar un proyecto aleatorio (solo para demostración)
  generarProyectoAleatorio() {
    return {
      codigoProyecto: 'P001',
      nombreLider: 'Líder del Proyecto',
      nombreProyecto: 'Proyecto XYZ',
      descripcion: 'Esta es una descripción detallada del proyecto. ...',
    };
  }

  // Función para agregar un nuevo integrante al grupo
  agregarIntegrante() {
    // Lógica para agregar un nuevo integrante al grupo
    // Puedes implementar servicios o realizar la lógica directamente aquí.
  }

  // Función para expulsar a un integrante del grupo
  expulsarIntegrante(integrante: any) {
    // Lógica para expulsar a un integrante del grupo
    // Puedes implementar servicios o realizar la lógica directamente aquí.
  }
  // Función para ir atrás
  goBack() {
    this.navCtrl.back(); // Esta función regresa a la página anterior
  }

}
