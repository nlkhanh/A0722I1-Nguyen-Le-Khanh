import {AfterViewChecked, Component, DoCheck, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Customer} from '../../customer-model/Customer';
import {CustomerService} from '../../customer-service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit, AfterViewChecked {
  // tslint:disable-next-line:variable-name
  private _customers: Customer[];
  // tslint:disable-next-line:variable-name
  private _modalBody: string;
  // tslint:disable-next-line:variable-name
  private _deleteIdsDisplay: string[] = [];
  // tslint:disable-next-line:variable-name
  private _deleteIds: number[] = [];
  p = 1;

  // tslint:disable-next-line:variable-name
  constructor(private _customerService: CustomerService, private _router: Router) {
  }

  ngOnInit(): void {
    this._customerService.findAll().subscribe(next => this.customers = next);
  }


  get customers(): Customer[] {
    return this._customers;
  }

  set customers(value: Customer[]) {
    this._customers = value;
  }

  get modalBody(): string {
    return this._modalBody;
  }

  set modalBody(value: string) {
    this._modalBody = value;
  }

  search() {
    const nameInput = document.getElementById('name-input') as HTMLInputElement;
    const startDateInput = document.getElementById('start-date-input') as HTMLInputElement;
    const endDateInput = document.getElementById('end-date-input') as HTMLInputElement;
    const nameValue = nameInput.value;
    const startDateValue = startDateInput.value;
    const endDateValue = endDateInput.value;

    if (nameValue === '' && startDateValue === '' && endDateValue === '') {
      this._customerService.findAll().subscribe(next => {
        this.customers = next;
      });
    } else {
      this._customerService.findAllByNameAndBirthday(nameValue, startDateValue, endDateValue).subscribe(
        customersSearch => this.customers = customersSearch
      );
    }
  }

  showCreateForm() {
    this._router.navigateByUrl('/customers/create');
  }

  idsClick() {
    const ids = document.getElementById('ids') as HTMLInputElement;
    const idsItems = document.getElementsByName('ids-item');
    idsItems.forEach((e: HTMLInputElement) => {
      this.customers.find(customer => customer.id === +e.value).isCheck = ids.checked;
    });
  }

  idsItemClick() {
    const ids = document.getElementById('ids') as HTMLInputElement;
    const idsItems = document.getElementsByName('ids-item');
    let checked = true;

    if (idsItems.length === 0) {
      checked = false;
    }

    idsItems.forEach((e: HTMLInputElement) => {
      if (!this.customers.find(customer => customer.id === +e.value).isCheck) {
        checked = false;
      }
    });

    ids.checked = checked;
  }

  showUpdateForm(id: number) {
    this._router.navigateByUrl('customers/update/' + id);
  }

  showModalDelete() {
    const modalBtnDelete = document.getElementById('modal-btn-delete');
    this.customers.forEach(customer => {
      if (customer.isCheck) {
        this._deleteIds.push(customer.id);
        this._deleteIdsDisplay.push(customer.name + ' (id = ' + customer.id + ')');
      }
    });

    if (this._deleteIds.length === 0) {
      this.modalBody = 'Bạn chưa chọn đối tuượng để xóa.';
      modalBtnDelete.classList.add('disabled');
    } else {
      this.modalBody = 'Bạn muốn xóa các dổi tượng: ' + this._deleteIdsDisplay.join(', ');
      modalBtnDelete.classList.remove('disabled');
    }
  }

  async delete() {
    for (const i of this._deleteIds) {
      await this._customerService.deleteById(i).toPromise();
    }
    const modalBtnCancel = document.getElementById('modal-btn-cancel');
    const ids = document.getElementById('ids') as HTMLInputElement;
    ids.checked = false;
    this._customerService.findAll().subscribe(next => {
      this.customers = next;
      modalBtnCancel.click();
    });
  }

  cancelDelete() {
    this._deleteIds = [];
    this._deleteIdsDisplay = [];
    this.modalBody = '';
  }

  ngAfterViewChecked(): void {
    this.idsItemClick();
  }
}
