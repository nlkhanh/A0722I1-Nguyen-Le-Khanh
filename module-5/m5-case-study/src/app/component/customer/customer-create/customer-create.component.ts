import {Component, OnInit} from '@angular/core';
import {CustomerType} from '../../../model/customer-type/customerType';
import {CustomerTypesService} from '../../../service/customer-types.service';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import {CustomersService} from '../../../service/customers.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {Customer} from '../../../model/customer/customer';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css'],
})
export class CustomerCreateComponent implements OnInit {
  customerTypes: CustomerType[];
  createForm: FormGroup;
  subscribe: Subscription;
  idUpdate: number;
  btnFormCreateUpdateSubmitText: string;
  formCreateUpdateTitle: string;

  constructor(
    private customerTypesService: CustomerTypesService,
    private customersService: CustomersService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.customerTypesService.findAll().subscribe(next => this.customerTypes = next);

    this.createForm = new FormGroup({
      id: new FormControl(''),
      customerType: new FormControl('', Validators.required),
      fullName: new FormControl(''),
      birthday: new FormControl('', this.checkAge),
      idCard: new FormControl(''),
      phone: new FormControl(''),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl(''),
    });

    this.btnFormCreateUpdateSubmitText = 'Thêm';
    this.formCreateUpdateTitle = 'Thêm mới khách hàng';

    this.subscribe = this.activatedRoute.paramMap.subscribe(
      (param: ParamMap) => {
        this.idUpdate = +param.get('id');
        if (this.idUpdate) {
          this.btnFormCreateUpdateSubmitText = 'Cập nhật';
          this.formCreateUpdateTitle = 'Cập nhật khách hàng';
          let customerUpdate: Customer;
          this.customersService.findById(this.idUpdate).subscribe(next => customerUpdate = next);
          this.createForm.setValue({
            id: customerUpdate.id,
            customerType: customerUpdate.customerType.id,
            fullName: customerUpdate.fullName,
            birthday: customerUpdate.birthday.toISOString().substring(0, 10),
            idCard: customerUpdate.idCard,
            phone: customerUpdate.phone,
            email: customerUpdate.email,
            address: customerUpdate.address,
          });
        }
      }
    );
  }

  submit() {
    if (this.createForm.valid) {
      const customer: Customer = this.createForm.value;
      const idFormControl = this.createForm.get('id').value;
      customer.birthday = new Date(customer.birthday);
      this.customerTypesService.findById(+customer.customerType).subscribe(next => {
        customer.customerType = next;
        if (idFormControl === '') {
          this.customersService.create(customer).subscribe();
        } else {
          this.customersService.update(customer).subscribe();
        }
        this.router.navigate(['/customers']);
      });
    }
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
