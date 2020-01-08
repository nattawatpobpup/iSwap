import { Component, OnInit } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import {FormControl, NgForm} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddItemService } from '../shared/item/add-item.service';
import {ActivatedRoute}from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';


export interface Typ {
  value: string;
  viewValue: string;
}

export interface Hashtag {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-addi',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {
  user:String;
  typs:Array<any>;
  hashtags:Array<any>;
  users:Array<any>; 
  userid:number;
  sub: any;
 username:'';

  myitem : any = {
   
    itemName:'',
    typName:'',
    hashtagName:'',
    desrciptionInput:'',
    img:''
  }
  constructor(
    private controller:AddItemService,private httpClient: HttpClient,private router:Router ,private rout:ActivatedRoute

  ) { }

  ngOnInit() {
      if(!LoginPageComponent.authentication){
            this.router.navigate(['login']);
            alert('กรุณาเข้าสู่ระบบ');
          }else{
      
      this.controller.getCategorys().subscribe(data => {
        this.typs = data;
        console.log(this.typs);
      });
      this.controller.getHashtags().subscribe(data => {
        this.hashtags = data;
        console.log(this.hashtags);
      });


  this.controller.getUsers(LoginPageComponent.userIdLogin).subscribe(data => {
    this.user = data.username;
    console.log(this.user);
  });}
}
  postItem(){
    if(this.myitem.img === ''||this.myitem.itemName === ''||this.myitem.typName === ''||this.myitem.hashtagName ===''||this.myitem.desrciptionInput==='' )
    alert('กรอกข้อมูลให้ครบ');
    else{
    this.httpClient.post('http://localhost:8080/item/'+this.myitem.typName+'/'+this.myitem.hashtagName+'/'+this.user,this.myitem).subscribe(
      data => {
        
          console.log('PUT Request is successful', data);
          this.router.navigate(['shows']);
      },
      error => {
        alert('Error');
        console.log('Error', error);
    }
    
  );
  } 
}

}
