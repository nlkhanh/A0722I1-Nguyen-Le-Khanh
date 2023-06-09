import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {CustomerListComponent} from './component/customer/customer-list/customer-list.component';
import {EmployeeCreateComponent} from './component/employee/employee-create/employee-create.component';
import {CustomerCreateComponent} from './component/customer/customer-create/customer-create.component';
import {FacilityCreateComponent} from './component/facility/facility-create/facility-create.component';
import {ContractCreateComponent} from './component/contract/contract-create/contract-create.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customers', component: CustomerListComponent},
  {path: 'customers/create', component: CustomerCreateComponent},
  {path: 'customers/update/:id', component: CustomerCreateComponent},
  // {path: 'customers/delete', component: CustomerListComponent},
  // {path: 'employees', component: CustomerListComponent},
  {path: 'employees/create', component: EmployeeCreateComponent},
  // {path: 'employees/update', component: CustomerListComponent},
  // {path: 'employees/delete', component: CustomerListComponent},
  // {path: 'facilities', component: CustomerListComponent},
  {path: 'facilities/create', component: FacilityCreateComponent},
  // {path: 'facilities/update', component: CustomerListComponent},
  // {path: 'facilities/delete', component: CustomerListComponent},
  // {path: 'contracts', component: CustomerListComponent},
  {path: 'contracts/create', component: ContractCreateComponent},
  // {path: 'contracts/update', component: CustomerListComponent},
  // {path: 'contracts/delete', component: CustomerListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
