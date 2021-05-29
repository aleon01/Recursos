
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { Usuarios } from '../_model/usuarios';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  /*usuarios:Observable<any[]>;

  private url: string = `${environment.HOST}/usuarios`;

  constructor(private http: HttpClient) { }

  guardarUsuarios(usuario: Usuarios) {
  return this.http.post(`${this.url}/guardar`, usuario);
  }
  
  getUsuarios(){
    return this.usuarios;
  }*/
}
