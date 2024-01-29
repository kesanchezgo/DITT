import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  searchQuery: string = '';
  proyectos: any[] = [];

  constructor(private router: Router) {
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
        esLider: Math.random() < 0.5, // Simula si eres líder o no (ajustar según tu lógica real)
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

  // Función para ver detalles del proyecto
  verDetalles(proyecto: any) {
    // Lógica para ver detalles del proyecto
    // Puedes implementar navegación u otras acciones según tus necesidades.
    // Navegar a project-detail con el ID del proyecto como parámetro
    this.router.navigate(['/project-detail', proyecto.id]); 
  }

  // Función para solicitar préstamo (solo visible si eres líder del proyecto)
  solicitarPrestamo(proyecto: any) {
    // Lógica para solicitar préstamo
    // Puedes implementar navegación u otras acciones según tus necesidades.
  }

  // Función para verificar si eres líder del proyecto
  esLider(proyecto: any): boolean {
    // Lógica para verificar si eres líder del proyecto
    // Retorna true si eres líder, false en caso contrario
    // Puedes ajustar esta lógica según cómo determines quién es líder.
    return proyecto && proyecto.esLider === true; // Ajusta según tu estructura de datos.
  }

}
