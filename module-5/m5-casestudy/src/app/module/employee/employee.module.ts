import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {EmployeeRoutingModule} from './employee-routing.module';
import {EmployeesComponent} from './employee-component/employees/employees.component';
import {EmployeeCreateUpdateComponent} from './employee-component/employee-create-update/employee-create-update.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [EmployeesComponent, EmployeeCreateUpdateComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EmployeeModule {
}
