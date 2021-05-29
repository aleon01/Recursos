import { UsuarioService } from './../../../_service/usuario.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Usuarios } from 'src/app/_model/usuarios';

interface Dependencia {
  value: string;
  viewValue: string;
}

interface TipoUsuario {
  valueT: string;
  viewValueT: string;
}
interface Extension {
  valueE: string;
  viewValueE: string;
}


@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  documento: number;
  nombre: string;
  selectedValueD: string;
  selectedValueT: string;
  correo: string;
  selectedValueE: string;
  user: string;
  contrasena: string;



  [x: string]: any;

  usuario: Usuarios = new Usuarios();
  form: FormGroup;

  dependencias: Dependencia[] = [
    { value: 'psicología-0', viewValue: 'Psicología' },
    { value: 'ingenieríaAmbiental-1', viewValue: 'Ingeniería Ambiental' },
    { value: 'ingenieríaAgronómica-2', viewValue: 'Ingeniería Agronómica' },
    { value: 'ingenieríaSistemas-3', viewValue: 'Ingeniería de Sistemas y Computación' },
    { value: 'contaduríaPublica-4', viewValue: 'Contaduría Pública' },
    { value: 'administraciónEmpresas-5', viewValue: 'Administración de Empresas' }
  ];
  tiposusuarios: TipoUsuario[] = [
    { valueT: 'administrador-0', viewValueT: 'Administrador' },
    { valueT: 'docente-1', viewValueT: 'Docente' }
  ];
  extensiones: Extension[] = [
    { valueE: 'sedeFusagasuga-0', viewValueE: 'Sede Fusagasugá ' },
    { valueE: 'seccionalGirardot-1', viewValueE: 'Seccional Girardot' },
    { valueE: 'SeccionalUbate-2', viewValueE: 'Seccional Ubaté' },
    { valueE: 'extensionChia-3', viewValueE: 'Extensión Chía' },
    { valueE: 'extensionChoconta-4', viewValueE: 'Extensión Chocontá' },
    { valueE: 'extensionFacatativa-5', viewValueE: 'Extensión Facatativá' },
    { valueE: 'extensionSoacha-6', viewValueE: 'Extensión Soacha' },
    { valueE: 'extensionZipaquirá-7', viewValueE: 'Extensión Zipaquirá' }
  ];



  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
  }

  //-----------Para guardar, impresión por consola
  guardarUsuario(): void {
    let user = new Usuarios();

    user.documento = this.documento;
    user.nombre = this.nombre;
    user.dependencia = this.selectedValueD;
    user.tipoUsuario = this.selectedValueT;
    user.correo = this.correo;
    user.extension = this.selectedValueE;
    user.user = this.user;
    user.contrasena = this.contrasena;

    /*this.usuarioService.guardarUsuarios(user).subscribe(()=>{
      this.openSnackBar('Registro guardado satisfactiriamente');
    });*/

    /*user.documento = this.form.value['ldocumento'];
    user.nombre = this.form.value['lnombre'];
    user.dependencia = this.form.value['Sdependencia'];;
    user.tipoUsuario = this.form.value['StipoUsuario'];;
    user.correo = this.form.value['lcorreo'];;
    user.extension = this.form.value['Sextension'];;
    user.user = this.form.value['lusuario'];;
    user.contrasena = this.form.value['Sextension'];;
    /* this.usuarioService.guardarUsuarios(user).subscribe(() => {
       this.openSnackBar('Guardado satisfactoreamente');
       this.form.reset();
     });*/
    //console.log(this.usuario);
  }
  obtenrUsuario(){

  }
  actualizarUsuarios(){

  }
  eliminarUsuarios(){
    
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, 'Información', {
      duration: 3000,
    });
  }

}

