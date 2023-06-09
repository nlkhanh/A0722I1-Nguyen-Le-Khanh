import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Customer} from '../customer-model/Customer';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private _API_URL = 'http://localhost:3000/customers';

  // tslint:disable-next-line:variable-name
  constructor(private _http: HttpClient) {
  }

  findAll(): Observable<Customer[]> {
    return this._http.get<Customer[]>(this._API_URL);
  }

  findAllByNameAndBirthday(name: string, startDate: string, endDate: string): Observable<Customer[]> {
    let condition = '';
    let nameCondition = '';
    let dateCondition = '';

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

    if (nameCondition !== '' && dateCondition !== '') {
      condition = '?' + nameCondition + '&' + dateCondition;
    } else if (nameCondition !== '') {
      condition = '?' + nameCondition;
    } else if (dateCondition !== '') {
      condition = '?' + dateCondition;
    }

    return this._http.get<Customer[]>(this._API_URL + condition);
  }

  findById(id: number): Observable<Customer> {
    return this._http.get<Customer>(this._API_URL + '/' + id);
  }

  deleteById(id: number): Observable<void> {
    return this._http.delete<void>(this._API_URL + '/' + id);
  }

  save(customer: Customer): Observable<Customer> {
    if (customer.id) {
      return this._http.put<Customer>(this._API_URL + '/' + customer.id, customer);
    }
    return this._http.post<Customer>(this._API_URL, customer);
  }
}
