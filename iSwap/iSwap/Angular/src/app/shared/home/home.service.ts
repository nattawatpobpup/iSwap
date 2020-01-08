import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
public API = '//localhost:8080';
  constructor(private http: HttpClient) { }
getUser(id): Observable<any> {
    return this.http.get(this.API + '/getUser/'+id);
  }
}
