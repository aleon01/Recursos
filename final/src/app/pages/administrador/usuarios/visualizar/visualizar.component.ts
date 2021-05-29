import { UsuarioService } from './../../../../_service/usuario.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

export interface ListUsuarios {
  documento: number;
    nombre: string;
    dependencia: string;
    tipoUsuario: string;
    correo: string;
    extension: string;
    user: string;
    contrasena: string;
}


@Component({
  selector: 'app-visualizar',
  templateUrl: './visualizar.component.html',
  styleUrls: ['./visualizar.component.css']
})
export class VisualizarComponent implements OnInit {

 constructor(private usuarioService: UsuarioService){}
  displayedColumns: string[] = ['documento', 'nombre', 'dependencia', 'tipoUsuario', 'correo','extension', 'usuario'];
  dataSource = new MatTableDataSource();

  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {
    //this.getTodosUsuarios();
  }

  /*getTodosUsuarios(){
    this.usuarioService.getUsuarios().subscribe(res => {
      this.dataSource.data = res;
    })
  }*/

  
}
