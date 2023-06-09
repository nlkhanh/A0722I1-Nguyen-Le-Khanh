import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../employee-model/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  // tslint:disable-next-line:variable-name
  private _API_URL = 'http://localhost:3000/employees';

  // tslint:disable-next-line:variable-name
  constructor(private _http: HttpClient) {
  }

  findAll(): Observable<Employee[]> {
    return this._http.get<Employee[]>(this._API_URL);
  }

  findAllByManyThings(name: string,
                      startDate: string,
                      endDate: string,
                      positionId: string,
                      divisionId: string,
                      educationDegreeId: string): Observable<Employee[]> {
    let condition = '?';
    let nameCondition = '';
    let dateCondition = '';
    let positionCondition = '';
    let divisionCondition = '';
    let educationDegreeCondition = '';

    if (name !== '') {
      nameCondition += 'name_like=' + name;
    }

    if (startDate !== '' && endDate !== '') {
      dateCondition += 'birthday_gte=' + startDate + '&birthday_lte=' + endDate;
    } else if (startDate !== '') {
      dateCondition += 'birthday_gte=' + startDate;
    } else if (endDate !== '') {
      dateCondition += 'birthday_lte=' + endDate;
    }

    if (positionId !== '') {
      positionCondition += 'position.id=' + positionId;
    }

    if (divisionId !== '') {
      divisionCondition += 'division.id=' + divisionId;
    }

    if (educationDegreeId !== '') {
      educationDegreeCondition += 'educationDegree.id=' + educationDegreeId;
    }

    if (nameCondition !== '') {
      condition += nameCondition + '&';
    }

    if (dateCondition !== '') {
      condition += dateCondition + '&';
    }

    if (positionId !== '') {
      condition += positionCondition + '&';
    }

    if (divisionId !== '') {
      condition += divisionCondition + '&';
    }

    if (educationDegreeCondition !== '') {
      condition += educationDegreeCondition + '&';
    }

    if (condition === '?') {
      condition = '';
    } else {
      condition = condition.slice(0, -1);
    }

    return this._http.get<Employee[]>(this._API_URL + condition);
  }

  findById(id: number): Observable<Employee> {
    return this._http.get<Employee>(this._API_URL + '/' + id);
  }

  deleteById(id: number): Observable<void> {
    return this._http.delete<void>(this._API_URL + '/' + id);
  }

  save(employee: Employee): Observable<Employee> {
    if (employee.id) {
      return this._http.put<Employee>(this._API_URL + '/' + employee.id, employee);
    }
    return this._http.post<Employee>(this._API_URL, employee);
  }
}
