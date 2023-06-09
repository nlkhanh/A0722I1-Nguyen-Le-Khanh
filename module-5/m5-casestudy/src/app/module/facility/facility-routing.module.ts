import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FacilitiesComponent} from './facility-component/facilities/facilities.component';
import {FacilityCreateUpdateComponent} from './facility-component/facility-create-update/facility-create-update.component';


const routes: Routes = [
  {path: '', component: FacilitiesComponent},
  {path: 'create', component: FacilityCreateUpdateComponent},
  {path: 'update/:id', component: FacilityCreateUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
