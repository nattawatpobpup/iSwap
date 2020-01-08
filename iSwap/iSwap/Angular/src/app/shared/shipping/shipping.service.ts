import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ShippingService {
  public API = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getProvince(): Observable<any>{
    return this.http.get(this.API + '/Province');
  }

  getShippingStatus(): Observable<any>{
    return this.http.get(this.API + '/ShippingStatus');
  }
  
  getShippingInfo(): Observable<any> {
    return this.http.get(this.API + '/Shipping');
  }
}
