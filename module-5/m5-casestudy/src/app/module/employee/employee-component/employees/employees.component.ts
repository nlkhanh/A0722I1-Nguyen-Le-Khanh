import {AfterViewChecked, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {EmployeeService} from '../../employee-service/employee.service';
import {Employee} from '../../employee-model/Employee';
import {ObjectLookUp} from '../../../../model/ObjectLookUp';
import {ObjectLookUpService} from '../../../../service/object-look-up.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit, AfterViewChecked {
  // tslint:disable-next-line:variable-name
  private _employees: Employee[];
  // tslint:disable-next-line:variable-name
  private _modalBody: string;
  // tslint:disable-next-line:variable-name
  private _deleteIdsDisplay: string[] = [];
  // tslint:disable-next-line:variable-name
  private _deleteIds: number[] = [];
  // tslint:disable-next-line:variable-name
  private _positions: ObjectLookUp[];
  // tslint:disable-next-line:variable-name
  private _divisions: ObjectLookUp[];
  // tslint:disable-next-line:variable-name
  private _educationDegrees: ObjectLookUp[];
  p = 1;

  // tslint:disable-next-line:variable-name
  constructor(private _employeeService: EmployeeService, private _router: Router, private _objectLookUpService: ObjectLookUpService) {
  }

  ngOnInit(): void {
    this._employeeService.findAll().subscribe(next => this.employees = next);
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

  get employees(): Employee[] {
    return this._employees;
  }

  set employees(value: Employee[]) {
    this._employees = value;
  }

  get modalBody(): string {
    return this._modalBody;
  }

  set modalBody(value: string) {
    this._modalBody = value;
  }

  search() {
    const nameAddressInput = document.getElementById('name-address-input') as HTMLInputElement;
    const startDateInput = document.getElementById('start-date-input') as HTMLInputElement;
    const endDateInput = document.getElementById('end-date-input') as HTMLInputElement;
    const positionInput = document.getElementById('position-input') as HTMLInputElement;
    const divisionInput = document.getElementById('division-input') as HTMLInputElement;
    const educationDegreeInput = document.getElementById('education-degree-input') as HTMLInputElement;
    const nameAddressValue = nameAddressInput.value;
    const startDateValue = startDateInput.value;
    const endDateValue = endDateInput.value;
    const positionValue = positionInput.value;
    const divisionValue = divisionInput.value;
    const educationDegreeValue = educationDegreeInput.value;

    if (nameAddressValue === '' && startDateValue === '' && endDateValue === '' &&
      positionValue === '' && divisionValue === '' && educationDegreeValue === '') {
      this._employeeService.findAll().subscribe(next => {
        this.employees = next;
      });
    } else {
      this._employeeService.findAllByManyThings(
        nameAddressValue, startDateValue, endDateValue, positionValue, divisionValue, educationDegreeValue
      ).subscribe(
        employeesSearch => this.employees = employeesSearch
      );
    }
  }

  showCreateForm() {
    this._router.navigateByUrl('/employees/create');
  }

  idsClick() {
    const ids = document.getElementById('ids') as HTMLInputElement;
    const idsItems = document.getElementsByName('ids-item');
    idsItems.forEach((e: HTMLInputElement) => {
      this.employees.find(employee => employee.id === +e.value).isCheck = ids.checked;
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
      if (!this.employees.find(employee => employee.id === +e.value).isCheck) {
        checked = false;
      }
    });

    ids.checked = checked;
  }

  showUpdateForm(id: number) {
    this._router.navigateByUrl('employees/update/' + id);
  }

  showModalDelete() {
    const modalBtnDelete = document.getElementById('modal-btn-delete');
    this.employees.forEach(employee => {
      if (employee.isCheck) {
        this._deleteIds.push(employee.id);
        this._deleteIdsDisplay.push(employee.name + ' (id = ' + employee.id + ')');
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
      await this._employeeService.deleteById(i).toPromise();
    }
    const modalBtnCancel = document.getElementById('modal-btn-cancel');
    const ids = document.getElementById('ids') as HTMLInputElement;
    ids.checked = false;
    this._employeeService.findAll().subscribe(next => {
      this.employees = next;
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
