import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractRoutingModule } from './contract-routing.module';
import { ContractsComponent } from './contract-component/contracts/contracts.component';
import { ContractCreateUpdateComponent } from './contract-component/contract-create-update/contract-create-update.component';
import { ContractDetailsComponent } from './contract-component/contract-details/contract-details.component';
import { ContractDetailCreateUpdateComponent } from './contract-component/contract-detail-create-update/contract-detail-create-update.component';


@NgModule({
  declarations: [ContractsComponent, ContractCreateUpdateComponent, ContractDetailsComponent, ContractDetailCreateUpdateComponent],
  imports: [
    CommonModule,
    ContractRoutingModule
  ]
})
export class ContractModule { }
