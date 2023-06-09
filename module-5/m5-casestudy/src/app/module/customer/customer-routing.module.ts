import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomersComponent} from './customer-component/customers/customers.component';
import {CustomerCreateUpdateComponent} from './customer-component/customer-create-update/customer-create-update.component';


const routes: Routes = [
  {path: '', component: CustomersComponent},
  {path: 'create', component: CustomerCreateUpdateComponent},
  {path: 'update/:id', component: CustomerCreateUpdateComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
