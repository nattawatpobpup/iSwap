import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { LoginService } from '../shared/login/login.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  usersData: Array<any>;
  static usernameLogin: String;
  static userIdLogin: number;
  static authentication: boolean = false;

  loginData: any = {
    usernameInput:null,
    passwordInput:null
  }
  constructor(private loginService: LoginService,private router: Router) { }

  ngOnInit() {
    LoginPageComponent.authentication = false;
  }

  login(){
    if(this.loginData.usernameInput === null || this.loginData.passwordInput === null){
          alert("Please fill Username and Password");
    }else{
      this.loginService.getUserByUsername(this.loginData.usernameInput).subscribe(
      data => {
        if(data === null){
          alert("ไม่มี Username นี้อยู่ในระบบ");
        }else if(this.loginData.passwordInput === data.password){
          LoginPageComponent.userIdLogin = data.id;
          LoginPageComponent.usernameLogin = data.username;
          LoginPageComponent.authentication = true;
          this.router.navigate(['shows']);
        }else{
          alert("Password ไม่ถูกต้อง");

        }
      },
      error => {
          alert("Username invalid");
      }
      );
    }
  }
}
