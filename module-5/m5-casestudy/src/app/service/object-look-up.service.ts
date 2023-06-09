import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {ObjectLookUp} from '../model/ObjectLookUp';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObjectLookUpService {
  private _API_URL = '';

  // tslint:disable-next-line:variable-name
  constructor(private _http: HttpClient) {
  }

  get API_URL(): string {
    return this._API_URL;
  }

  set API_URL(value: string) {
    this._API_URL = value;
  }

  findAll(): Observable<ObjectLookUp[]> {
    return this._http.get<ObjectLookUp[]>(this._API_URL);
  }

  findById(id: number): Observable<ObjectLookUp> {
    return this._http.get<ObjectLookUp>(this._API_URL + '/' + id);
  }
}
