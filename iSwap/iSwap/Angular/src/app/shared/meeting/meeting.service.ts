import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class MeetingService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/Provinces');
  }
  getTime(): Observable<any> {
    return this.http.get(this.API + '/Times');
  }
  getMeetingStatus(): Observable<any> {
    return this.http.get(this.API + '/status');
  }
  getAllformMeeting(): Observable<any> {
    return this.http.get(this.API + '/Meetingshow');
  }
  getProposal(): Observable<any>{
    return this.http.get(this.API + '/proposal');
  }
  updateMeeting(meetingId,statusId): Observable<any> {
    return this.http.get(this.API + '/update/'  + meetingId + '/' + statusId);
  }
  getuserReceiveName(username): Observable<any> {
    return this.http.get(this.API + '/getMeetingReceive/'  + username);
  }
  getuserOfferName(username): Observable<any> {
    return this.http.get(this.API + '/getMeetingOffer/'  + username);
  }
}
