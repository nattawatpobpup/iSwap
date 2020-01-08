import { Component, OnInit } from '@angular/core';
import { MatDialog} from '@angular/material';
import { AddComponent } from 'src/app/add/add.component';
import { from } from 'rxjs';
import { AddItemService } from '../shared/item/add-item.service';
import { Router } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';


@Component({
  selector: 'app-shows',
  templateUrl: './shows.component.html',
  styleUrls: ['./shows.component.css']
})
export class ShowsComponent implements OnInit {

dataColumns: string[] = ['img','itemname','categoryname','descrition','proposal'];
item:Array<any>;

  constructor(private controller:AddItemService,private  dialog: MatDialog,private router: Router) {
    
   }
  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{
    this.controller.getItem().subscribe(data => {
      this.item = data;
      console.log(this.item);
    });
  }}

  proposal(element){
    this.router.navigate(['proposal/' + element.id]);
  }
}
