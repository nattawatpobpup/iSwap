import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProposalService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<any> {
    return this.http.get(this.API + '/user');
  }

  getUser(user_id): Observable<any> {
    return this.http.get(this.API + '/getUser/' + user_id);
  }

  getTradeOption(): Observable<any> {
    return this.http.get(this.API + '/tradeOption');
  }

  getItem(user_id): Observable<any> {
    return this.http.get(this.API + '/item/'+ user_id);
  }

  getItemById(item_id): Observable<any> {
    return this.http.get(this.API + '/getItemById/'+ item_id);
  }

  getProposal(): Observable<any> {
      return this.http.get(this.API + '/proposal');
  }

  getProposalOffer(username,status_id): Observable<any> {
      return this.http.get(this.API + '/getProposalOffer/' + username + '/' +status_id);
  }


  getProposalReceiver(username): Observable<any> {
      return this.http.get(this.API + '/getProposalReceiver/' + username);
  }
}
