import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ObjectLookUp} from '../../../../model/ObjectLookUp';
import {CustomerService} from '../../customer-service/customer.service';
import {ObjectLookUpService} from '../../../../service/object-look-up.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../../customer-model/Customer';

@Component({
  selector: 'app-customers-create-update',
  templateUrl: './customer-create-update.component.html',
  styleUrls: ['./customer-create-update.component.css']
})
export class CustomerCreateUpdateComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  private _formCreateUpdateTitle = '';
  // tslint:disable-next-line:variable-name
  private _createUpdateForm: FormGroup;
  // tslint:disable-next-line:variable-name
  private _customerTypes: ObjectLookUp[];
  // tslint:disable-next-line:variable-name
  private _btnFormCreateUpdateSubmitText = '';

  // tslint:disable-next-line:variable-name
  constructor(private _customerService: CustomerService,
              // tslint:disable-next-line:variable-name
              private _customerTypeService: ObjectLookUpService,
              // tslint:disable-next-line:variable-name
              private _router: Router,
              // tslint:disable-next-line:variable-name
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._customerTypeService.API_URL = 'http://localhost:3000/customerTypes';
    this._customerTypeService.findAll().subscribe(next => this.customerTypes = next);
    this.createUpdateForm = new FormGroup({
      id: new FormControl(''),
      customerType: new FormControl('', Validators.required),
      name: new FormControl(''),
      birthday: new FormControl('', this.checkAge),
      idCard: new FormControl(''),
      phone: new FormControl(''),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('')
    });

    this._activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.formCreateUpdateTitle = 'Cập nhật khách hàng';
        this.btnFormCreateUpdateSubmitText = 'Cập nhật';
        this._customerService.findById(params.id).subscribe(customer => {
          this.createUpdateForm.setValue(customer);
          this.createUpdateForm.get('customerType').setValue(customer.customerType.id);
        });
      } else {
        this.formCreateUpdateTitle = 'Thêm mới khách hàng';
        this.btnFormCreateUpdateSubmitText = 'Thêm mới';
      }
    });
  }

  get formCreateUpdateTitle(): string {
    return this._formCreateUpdateTitle;
  }

  set formCreateUpdateTitle(value: string) {
    this._formCreateUpdateTitle = value;
  }

  get createUpdateForm(): FormGroup {
    return this._createUpdateForm;
  }

  set createUpdateForm(value: FormGroup) {
    this._createUpdateForm = value;
  }

  get customerTypes(): ObjectLookUp[] {
    return this._customerTypes;
  }

  set customerTypes(value: ObjectLookUp[]) {
    this._customerTypes = value;
  }

  get btnFormCreateUpdateSubmitText(): string {
    return this._btnFormCreateUpdateSubmitText;
  }

  set btnFormCreateUpdateSubmitText(value: string) {
    this._btnFormCreateUpdateSubmitText = value;
  }

  submit() {
    const customer = this.createUpdateForm.value as Customer;
    this._customerTypeService.findById(+customer.customerType).subscribe(customerType => {
      customer.customerType = customerType;
      this._customerService.save(customer).subscribe(savedCustomer => {
        this._router.navigateByUrl('/customers');
      });
    });
  }

  checkAge(c: AbstractControl): ValidationErrors | null {
    const currentYear = new Date().getFullYear();
    const currentMonth = new Date().getMonth() + 1;
    const currentDate = new Date().getDate();
    const birthYear = new Date(c.value).getFullYear();
    const birthMonth = new Date(c.value).getMonth() + 1;
    const birthDate = new Date(c.value).getDate();

    const yearDiff = currentYear - birthYear;
    const monthDiff = currentMonth - birthMonth;
    const dateDiff = currentDate - birthDate;

    let check = false;

    if (yearDiff > 18) {
      check = true;
    } else if (yearDiff === 18) {
      if (monthDiff > 0) {
        check = true;
      } else if (monthDiff === 0) {
        if (dateDiff >= 0) {
          check = true;
        }
      }
    }

    if (check) {
      return null;
    } else {
      return {babyBoy: true};
    }
  }
}
