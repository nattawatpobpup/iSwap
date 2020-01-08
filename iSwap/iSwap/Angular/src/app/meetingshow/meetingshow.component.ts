import { Component, OnInit } from '@angular/core';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {Router} from '@angular/router';
import {SelectionModel} from '@angular/cdk/collections';
import {MatTableDataSource,MatPaginator, MatSort, MatTable, MatTableModule, MatTabHeader,
MatHeaderRow, MatHeaderCell, MatHeaderCellDef, MatHeaderRowDef,
MatSortHeader, MatRow, MatRowDef,  MatCell, MatCellDef,MatDialog} from '@angular/material'
import { map, filter } from 'rxjs/operators';
import { HttpClient} from '@angular/common/http';
import { MeetingService } from '../shared/meeting/meeting.service';
import { LoginPageComponent } from '../login-page/login-page.component';

/**
* @title Basic use of `<table mat-table>`
*/
@Component({
  selector: 'app-meetingshow',
  templateUrl: './meetingshow.component.html',
  styleUrls: ['./meetingshow.component.css'],
})
export class MeetingshowComponent implements OnInit{
  private sub: any;
  private id: number;
  meetingByOfferColumns: string[] = ['no','item1','item2','receiver','date','landmark','text','status','update'];
  meetingByReceiveColumns: string[] = ['no','item1','item2','offer','telephone','callother','date','landmark','text','status'];
  statuss: Array<any>;

  showByReceive: Array<any>;
  showByOffer: Array<any>;

  getstatus: any = {
    meetingId:'',
    proposalId:'',
  }


  constructor(private meetingService : MeetingService,private router: Router, private rout: ActivatedRoute,
    private sanitizer: DomSanitizer,private matdialog : MatDialog, private httpClient: HttpClient) {

  }
  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{
    this.meetingService.getMeetingStatus().subscribe(data => {
        this.statuss= data;
      console.log(this.statuss);
    });

    this.meetingService.getuserReceiveName(LoginPageComponent.usernameLogin).subscribe(data => {
      this.showByReceive = data;
      console.log(this.showByReceive);
    });
    this.meetingService.getuserOfferName(LoginPageComponent.usernameLogin).subscribe(data => {
      this.showByOffer = data;
      console.log(this.showByOffer);
    });

  }}
  save(meetingId,proposalId){
    this.httpClient.put('http://localhost:8080/updateMeeting/'+meetingId+'/2',this.getstatus)
      .subscribe(
          data => {

              alert('อัพเดทสำเร็จ');
              console.log('PUT Request is successful', data);

          },
          error => {
              alert('อัพเดทไม่สำเร็จ');
              console.log('Error', error);
          }
      );
    this.httpClient.put('http://localhost:8080/updateProposal/'+proposalId+'/2',this.getstatus)
      .subscribe(data => {
        console.log('PUT Request is successful', data);
       },error => {
        console.log('Error', error);
       });

  }

}






