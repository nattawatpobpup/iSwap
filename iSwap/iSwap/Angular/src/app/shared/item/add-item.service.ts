import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AddItemService {

  constructor(private http:HttpClient) { }
  public API = '//localhost:8080';

  public getItem() :Observable<any>{
    return this.http.get(this.API + '/Item');
  }
  public getCategorys() :Observable<any>{
    return this.http.get(this.API + '/Category');
  }
  public getHashtags() :Observable<any>{
    return this.http.get(this.API + '/Hashtag');
  }
  public getUsers(id) :Observable<any>{
    return this.http.get(this.API + '/User/'+id);
  }
  
}
