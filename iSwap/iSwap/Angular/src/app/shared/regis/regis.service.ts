import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RegisService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/Provinces');
  }

  getGender():Observable<any> {
    return this.http.get(this.API + '/Genders');
  }

  getCareer():Observable<any> {
    return this.http.get(this.API + '/Careers');
  }
}
