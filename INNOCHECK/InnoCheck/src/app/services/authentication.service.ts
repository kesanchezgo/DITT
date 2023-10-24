import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private apiUrl = environment.apiUrl; // Reemplaza 'URL_DEL_BACKEND' con la URL de tu backend
  public httpOptions:any;
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    // Realiza una solicitud HTTP POST al backend para autenticar al usuario
    this.httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    const credentials = { username, password };
    return this.http.post(`${this.apiUrl}auth/signin`, credentials,this.httpOptions);
  }

  register(
    firstName: string,
    lastName: string,
    middleName: string,
    verificationCode: string,
    address: string,
    phone: string,
    birthDate: string,
    email: string,
    password: string
  ): Observable<any> {
    // Create an object with the user data to be registered
    const user = {
      firstName,
      lastName,
      middleName,
      verificationCode,
      address,
      phone,
      birthDate,
      email,
      password,
    };

    // Send an HTTP POST request to the backend to register the user
    this.httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    };
    return this.http.post(`${this.apiUrl}auth/signup`, user, this.httpOptions);
  }

  // Puedes agregar más métodos relacionados con la autenticación aquí, como cerrar sesión, verificar el estado de sesión, etc.
}
