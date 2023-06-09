import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-contract-detail-create',
  templateUrl: './contract-detail-create.component.html',
  styleUrls: ['./contract-detail-create.component.css']
})
export class ContractDetailCreateComponent implements OnInit {
  contractId = '';

  constructor() {
  }

  ngOnInit(): void {
  }

}
