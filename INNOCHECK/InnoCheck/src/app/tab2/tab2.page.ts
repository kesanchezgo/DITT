import { Component } from '@angular/core';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  searchQuery: string = '';
  proyectos: any[] = [];

  constructor() {
    // Generar datos aleatorios para demostración
    this.generarDatosAleatorios();
  }

  // Función para generar datos aleatorios de proyectos
  generarDatosAleatorios() {
    for (let i = 1; i <= 10; i++) {
      const proyecto = {
        id: i,
        nombreProyecto: `Proyecto ${i}`,
        nombreLider: `Líder ${i}`,
        descripcion: this.generarDescripcionAleatoria(),
      };

      this.proyectos.push(proyecto);
    }
  }

  // Función para generar descripciones aleatorias para los proyectos
  generarDescripcionAleatoria() {
    const palabras = ['Lorem', 'ipsum', 'dolor', 'sit', 'amet', 'consectetur', 'adipiscing', 'elit', 'sed', 'do', 'eiusmod'];
    const randomIndex = Math.floor(Math.random() * palabras.length);
    return palabras.slice(randomIndex, randomIndex + 5).join(' ');
  }

  // Función para realizar la búsqueda
  buscar() {
    // Lógica para realizar la búsqueda con this.searchQuery
    // Puedes implementar servicios o realizar la lógica directamente aquí
    // y luego actualizar this.proyectos con los resultados.
  }

  // Función para crear un nuevo proyecto
  nuevoProyecto() {
    // Lógica para crear un nuevo proyecto
    // Puedes implementar navegación u otras acciones según tus necesidades.
  }

  // Función para ver detalles del proyecto
  verProyecto(proyecto: any) {
    // Lógica para ver detalles del proyecto
    // Puedes implementar navegación u otras acciones según tus necesidades.
  }

  

}
