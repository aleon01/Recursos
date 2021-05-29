import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/_service/login.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  usuario = ''
  contrasena = ''
  invalidLogin = false

  constructor(private router: Router,
    private loginservice: LoginService) { }

  ngOnInit() {
  }
//---------- CheckLogin (): este método verifica si las credenciales del usuario son correctas llamando al AuthenticationService creado previamente
  checkLogin() {
    if (this.loginservice.authenticate(this.usuario, this.contrasena)
    ) {
      this.router.navigate(['admin'])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }
}

