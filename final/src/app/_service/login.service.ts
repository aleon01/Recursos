import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
 
  constructor() { }

  //----------Iniciar Sesión -- Autenticar () autenticar el nombre de usuario y la contraseña
  authenticate(usuario, contrasena) {
    if (usuario === "usuario" && contrasena === "contrasena") {
      sessionStorage.setItem('usuario', usuario)
      return true;
    } else {
      return false;
    }
  }
  //----------IsUserLoggedIn (): comprueba el almacenamiento de la sesión si existe un nombre de usuario. Si lo hace, devuelve verdadero
  isUserLoggedIn() {
    let user = sessionStorage.getItem('usuario')
    console.log(!(user === null))
    return !(user === null)
  }
  //----------cerrar sesión --  Logout (): este método borra el almacenamiento de sesión del nombre de usuario.
  logOut(){
    sessionStorage.removeItem('usuario')
  }

}
