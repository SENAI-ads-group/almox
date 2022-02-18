import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DepartamentoFormComponent } from './pages/form/departamento-form.component';
import { DepartamentoBuscaComponent } from './pages/busca/departamento-busca.component';

const routes: Routes = [
    { path: "", component: DepartamentoBuscaComponent },
    { path: "novo", component: DepartamentoFormComponent },
    { path: "visualizar/:id", component: DepartamentoFormComponent },
    { path: "editar/:id", component: DepartamentoFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DepartamentoRoutingModule { }
