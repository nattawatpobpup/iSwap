import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ReviewService {

  constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';

  getAllreviewshow(): Observable<any>{
    return this.http.get('//localhost:8080/review');
  }

  getReviewID(reviewId:number) : Observable<any>{
    return this.http.get('//localhost:8080/review/'+reviewId);
  }

  getUser(id) : Observable<any>{
    return this.http.get('//localhost:8080/user/'+id);
  }

   getLevel() : Observable<any>{
    return this.http.get('//localhost:8080/levels')
  }
   getProposal(id): Observable<any>{
    return this.http.get('//localhost:8080//'+id)
  }
  postReview(userIdSelect:number,levelIdSelect:number,propIdSelect:number,rating:number,comments:string):Observable<any>{
    return  this.http.post("//localhost:8080/review/create/"+userIdSelect+"/"+levelIdSelect+"/"+propIdSelect+"/"+rating+"/"+comments,this.getReviewID);
  }
}
