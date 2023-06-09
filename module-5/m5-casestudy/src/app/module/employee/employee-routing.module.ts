import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeesComponent} from './employee-component/employees/employees.component';
import {EmployeeCreateUpdateComponent} from './employee-component/employee-create-update/employee-create-update.component';


const routes: Routes = [
  {path: '', component: EmployeesComponent},
  {path: 'create', component: EmployeeCreateUpdateComponent},
  {path: 'update/:id', component: EmployeeCreateUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule { }
