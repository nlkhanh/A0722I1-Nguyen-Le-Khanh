import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacilityRoutingModule } from './facility-routing.module';
import { FacilitiesComponent } from './facility-component/facilities/facilities.component';
import { FacilityCreateUpdateComponent } from './facility-component/facility-create-update/facility-create-update.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [FacilitiesComponent, FacilityCreateUpdateComponent],
  imports: [
    CommonModule,
    FacilityRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class FacilityModule { }
