import { Component, OnInit } from '@angular/core';
import { MeetingService } from '../shared/meeting/meeting.service';
import { HttpClient} from '@angular/common/http';
import { MatDialogRef } from '@angular/material';
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';



@Component({
  selector: 'app-meeting',
  templateUrl: './meeting.component.html',
  styleUrls: ['./meeting.component.css']
})
export class MeetingComponent implements OnInit {
  private id: string;

  private pid: string;

  provinces: Array<any>;
  times: Array<any>;
  meetingData: any = {

    dateSelect:'',
    timeSelect:'',
    landmarkSelect:'',
    telephoneInput:'',
    callotherInput:'',
    textInput:''
   };
  constructor(private router: Router, private rout: ActivatedRoute,private meetingService:MeetingService , private httpClient: HttpClient,private sanitizer: DomSanitizer) {
    this.sanitizer = sanitizer;
  }

  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{
    this.rout.params.subscribe(params => {
        console.log(params);
        this.pid = params['id'];


    });
    this.meetingService.getProvince().subscribe(data => {
    this.provinces = data;
    console.log(this.provinces);
  });
    this.meetingService.getTime().subscribe(data => {
    this.times = data;
    console.log(this.times);
  });
  }}

  save(){
    if(this.meetingData.dateSelect ===''||
    this.meetingData.timeSelect ===''||
    this.meetingData.landmarkSelect ===''||
    this.meetingData.telephoneInput ===''||
    this.meetingData.callotherInput ===''||
    this.meetingData.textInput === ''
    ){
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else{
      this.httpClient.post('http://localhost:8080/newmeeting/create/1/' + this.pid ,this.meetingData)
      .subscribe(
          data => {
              alert('Request is successful');
              console.log('PUT Request is successful', data);

              this.router.navigate(['meetingshow']);
          },
          error => {
              alert('Request is not successful');
              console.log('Rrror', error);
          }
      );
    }
  }


}
