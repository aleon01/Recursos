import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioAdminComponent } from './pages/administrador/inicio-admin/inicio-admin.component';
import { TiposRecursosComponent } from './pages/administrador/tipos-recursos/tipos-recursos.component';
import { UsuariosComponent } from './pages/administrador/usuarios/usuarios.component';
import { VisualizarComponent } from './pages/administrador/usuarios/visualizar/visualizar.component';
import { InicioComponent } from './pages/inicio/inicio.component';


const routes: Routes = [
  {path: 'inicio', component: InicioComponent },
  {path: 'inicio-admin', component: InicioAdminComponent}, 
      {path:'tipos-recursos', component: TiposRecursosComponent},
          {path: 'usuarios', component: UsuariosComponent},
                  {path: 'visualizar', component: VisualizarComponent},
  
  
  
  { path: '',
  redirectTo: 'inicio',
  pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
