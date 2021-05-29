import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import { UsuariosComponent } from './pages/administrador/usuarios/usuarios.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { InicioAdminComponent } from './pages/administrador/inicio-admin/inicio-admin.component';
import { TiposRecursosComponent } from './pages/administrador/tipos-recursos/tipos-recursos.component';
import { VisualizarComponent } from './pages/administrador/usuarios/visualizar/visualizar.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuariosComponent,
    InicioComponent,
    InicioAdminComponent,
    TiposRecursosComponent,
    VisualizarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
