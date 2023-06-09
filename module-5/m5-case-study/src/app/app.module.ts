import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/layout/header/header.component';
import { FooterComponent } from './component/layout/footer/footer.component';
import { MainBodyComponent } from './component/layout/main-body/main-body.component';
import { CustomerCreateComponent } from './component/customer/customer-create/customer-create.component';
import { EmployeeCreateComponent } from './component/employee/employee-create/employee-create.component';
import { FacilityCreateComponent } from './component/facility/facility-create/facility-create.component';
import { ContractCreateComponent } from './component/contract/contract-create/contract-create.component';
import { ContractDetailCreateComponent } from './component/contract/contract-detail-create/contract-detail-create.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { SearchFormComponent } from './component/layout/search-form/search-form.component';
import { PaginationComponent } from './component/layout/pagination/pagination.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './component/home/home.component';
import { EmployeeListComponent } from './component/employee/employee-list/employee-list.component';
import { ModalDeleteComponent } from './component/layout/modal/modal-delete/modal-delete.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MainBodyComponent,
    CustomerCreateComponent,
    EmployeeCreateComponent,
    FacilityCreateComponent,
    ContractCreateComponent,
    ContractDetailCreateComponent,
    CustomerListComponent,
    SearchFormComponent,
    PaginationComponent,
    HomeComponent,
    EmployeeListComponent,
    ModalDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
