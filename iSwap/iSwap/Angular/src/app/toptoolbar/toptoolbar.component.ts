import { Component, OnInit } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';

@Component({
  selector: 'app-toptoolbar',
  templateUrl: './toptoolbar.component.html',
  styleUrls: ['./toptoolbar.component.css']
})
export class ToptoolbarComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() { }
  store(){this.router.navigate(['shows']);}
  proposal_list(){this.router.navigate(['proposal-list']);}
  deleteitem(){this.router.navigate(['delete']);}
  additem(){this.router.navigate(['add']);}
  show_profile(){this.router.navigate(['profile']);}
  show_shipping(){this.router.navigate(['show-shipping']);}
  meeting_show(){this.router.navigate(['meetingshow']);}
  login(){
    if(LoginPageComponent.authentication === true){
      alert('ท่านได้ออกจากระบบแล้ว');
    }
    this.router.navigate(['login']);
  }
}
