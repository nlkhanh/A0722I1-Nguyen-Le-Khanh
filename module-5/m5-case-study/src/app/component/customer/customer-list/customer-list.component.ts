import {AfterViewInit, Component, DoCheck, OnInit} from '@angular/core';
import {Customer} from '../../../model/customer/customer';
import {CustomersService} from '../../../service/customers.service';
import {Router} from '@angular/router';
import {CustomerType} from '../../../model/customer-type/customerType';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  cus1: Customer;
  customers: Customer[];
  deleteCustomersConfirmBody = '';
  deleteIds: any[] = [];

  constructor(private customerService: CustomersService, private router: Router) {
  }

  ngOnInit(): void {
    this.customerService.findAll().subscribe(next => this.customers = next);
  }

  idsClick(idsValue: boolean) {
    document.getElementsByName('ids-item').forEach((idsItem: HTMLInputElement) => {
      idsItem.checked = idsValue;
    });
  }

  idsItemClick(event: any) {
    const idsItemClick = event.target;
    const idsCheck: HTMLInputElement = document.getElementById('ids') as HTMLInputElement;
    if (idsItemClick.checked) {
      let count = 0;
      const idsItemList = document.getElementsByName('ids-item');
      idsItemList.forEach((idsItem: HTMLInputElement) => {
        if (idsItem.checked) {
          count++;
        }
      });
      if (count === idsItemList.length) {
        idsCheck.checked = true;
      }
    } else {
      idsCheck.checked = false;
    }
  }

  search(searchValue: string) {
    if (searchValue !== '') {
      this.customerService.findAllByNameOrAddress(searchValue).subscribe(next => this.customers = next);
    } else {
      this.customerService.findAll().subscribe(next => this.customers = next);
    }
  }

  deleteItems() {
    const idsItemList = document.getElementsByName('ids-item');
    const idsItemArr: any[] = [];
    let countItem = 0;
    idsItemList.forEach((idsItem: HTMLInputElement) => {
      if (idsItem.checked) {
        this.customerService.findById(+idsItem.value).subscribe(next => idsItemArr.push(next.fullName + '(id = ' + idsItem.value + ')'));
        this.deleteIds.push(+idsItem.value);
        countItem++;
      }
    });
    const btnAgree = document.getElementById('btn-agree-modal');
    if (countItem === 0) {
      this.deleteCustomersConfirmBody = 'Bạn chưa chọn đối tượng để xóa.';
      btnAgree.style.display = 'none';
    } else {
      this.deleteCustomersConfirmBody = idsItemArr.join(', ');
      btnAgree.style.display = 'inline-block';
    }
  }

  delete() {
    if (this.deleteIds.length > 0) {
      this.deleteIds.forEach(deleteId => this.customerService.delete(deleteId).subscribe());
      this.customerService.findAll().subscribe(next => this.customers = next);
      const ids: HTMLInputElement = document.getElementById('ids') as HTMLInputElement;
      ids.checked = false;
      const modalClose = document.getElementById('btn-close-modal');
      modalClose.click();
    }
  }

  showCreateForm() {
    this.router.navigate(['/customers/create']);
  }

  edit(id: number) {
    this.router.navigateByUrl('/customers/update/' + id);
  }
}
