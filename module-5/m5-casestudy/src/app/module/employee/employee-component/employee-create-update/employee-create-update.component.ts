import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ObjectLookUp} from '../../../../model/ObjectLookUp';
import {ObjectLookUpService} from '../../../../service/object-look-up.service';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../../employee-service/employee.service';
import {Employee} from '../../employee-model/Employee';

@Component({
  selector: 'app-employee-create-update',
  templateUrl: './employee-create-update.component.html',
  styleUrls: ['./employee-create-update.component.css'],
})

export class EmployeeCreateUpdateComponent implements OnInit {
  // tslint:disable-next-line:variable-name
  private _formCreateUpdateTitle = '';
  // tslint:disable-next-line:variable-name
  private _createUpdateForm: FormGroup;
  // tslint:disable-next-line:variable-name
  private _positions: ObjectLookUp[];
  // tslint:disable-next-line:variable-name
  private _divisions: ObjectLookUp[];
  // tslint:disable-next-line:variable-name
  private _educationDegrees: ObjectLookUp[];
  // tslint:disable-next-line:variable-name
  private _btnFormCreateUpdateSubmitText = '';

  // tslint:disable-next-line:variable-name
  constructor(private _employeeService: EmployeeService,
              // tslint:disable-next-line:variable-name
              private _objectLookUpService: ObjectLookUpService,
              // tslint:disable-next-line:variable-name
              private _router: Router,
              // tslint:disable-next-line:variable-name
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._objectLookUpService.API_URL = 'http://localhost:3000/positions';
    this._objectLookUpService.findAll().subscribe(ps => {
      this.positions = ps;
      this._objectLookUpService.API_URL = 'http://localhost:3000/divisions';
      this._objectLookUpService.findAll().subscribe(ds => {
        this.divisions = ds;
        this._objectLookUpService.API_URL = 'http://localhost:3000/educationDegrees';
        this._objectLookUpService.findAll().subscribe(ed => {
          this.educationDegrees = ed;
        });
      });
    });
    this.createUpdateForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      position: new FormControl('', Validators.required),
      division: new FormControl('', Validators.required),
      educationDegree: new FormControl('', Validators.required),
      birthday: new FormControl('', this.checkAge),
      idCard: new FormControl(''),
      salary: new FormControl(''),
      phone: new FormControl(''),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('')
    });

    this._activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.formCreateUpdateTitle = 'Cập nhật nhân viên';
        this.btnFormCreateUpdateSubmitText = 'Cập nhật';
        this._employeeService.findById(params.id).subscribe(employee => {
          this.createUpdateForm.setValue(employee);
          this.createUpdateForm.get('position').setValue(employee.position.id);
          this.createUpdateForm.get('division').setValue(employee.division.id);
          this.createUpdateForm.get('educationDegree').setValue(employee.educationDegree.id);
        });
      } else {
        this.formCreateUpdateTitle = 'Thêm mới nhân viên';
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

  get positions(): ObjectLookUp[] {
    return this._positions;
  }

  set positions(value: ObjectLookUp[]) {
    this._positions = value;
  }

  get divisions(): ObjectLookUp[] {
    return this._divisions;
  }

  set divisions(value: ObjectLookUp[]) {
    this._divisions = value;
  }

  get educationDegrees(): ObjectLookUp[] {
    return this._educationDegrees;
  }

  set educationDegrees(value: ObjectLookUp[]) {
    this._educationDegrees = value;
  }

  get btnFormCreateUpdateSubmitText(): string {
    return this._btnFormCreateUpdateSubmitText;
  }

  set btnFormCreateUpdateSubmitText(value: string) {
    this._btnFormCreateUpdateSubmitText = value;
  }

  submit() {
    const employee = this.createUpdateForm.value as Employee;
    const position = this.positions.find(ps => ps.id === +employee.position);
    const division = this.divisions.find(ds => ds.id === +employee.division);
    const educationDegree = this.educationDegrees.find(ed => ed.id === +employee.educationDegree);

    employee.position = position;
    employee.division = division;
    employee.educationDegree = educationDegree;

    this._employeeService.save(employee).subscribe(savedCustomer => {
      this._router.navigateByUrl('/employees');
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
