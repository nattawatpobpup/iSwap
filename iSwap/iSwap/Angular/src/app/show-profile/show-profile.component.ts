import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { ProfileService } from '../shared/profile/profile.service';
import { LoginPageComponent } from '../login-page/login-page.component';
import { Router} from '@angular/router';

@Component({
  selector: 'app-show-profile',
  templateUrl: './show-profile.component.html',
  styleUrls: ['./show-profile.component.css']
})
export class ShowProfileComponent implements OnInit {

  dataColumns: string[] = ['no','firstname','lastname','brithday','address','postcode','phonenum'];

  Profiles: Array<any>;
  constructor(private router: Router,private profileService:ProfileService,private  dialog: MatDialog) { }

  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{

    this.profileService.getProfile().subscribe(data => {
      this.Profiles = data;
      console.log(this.Profiles);
    });

  }}

}
