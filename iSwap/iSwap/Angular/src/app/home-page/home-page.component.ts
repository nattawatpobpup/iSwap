import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { HomeService } from '../shared/home/home.service';
import { LoginPageComponent } from '../login-page/login-page.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private homeService: HomeService,private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {if(!LoginPageComponent.authentication){
                    this.router.navigate(['login']);
                    alert('กรุณาเข้าสู่ระบบ');
                  }else{



  }}

}
