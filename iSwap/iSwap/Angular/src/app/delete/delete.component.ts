import { Component, OnInit } from '@angular/core';
import { AddItemService } from '../shared/item/add-item.service';
import { HttpClient } from '@angular/common/http';
import { RouterModule, Routes, Router } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  // httpClient:Array<any>;
  dataColumns: string[] = ['img','itemname','delelte'];
  item:Array<any>;
  
  
  constructor(private controller:AddItemService,private httpClient: HttpClient,private router:Router) { }

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
    delete(itemid){
    this.httpClient.delete('http://localhost:8080/item/delete/'+itemid).subscribe(
      data => {
          console.log('Delete Request is successful', data);
          this.router.navigate(['delete']);
      },
      error => {
          console.log('Error', error);
      }
    
  );
  }
 

}
