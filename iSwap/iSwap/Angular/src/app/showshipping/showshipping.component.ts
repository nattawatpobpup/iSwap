import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { RouterModule, Routes, Router } from '@angular/router';
import { ShippingService } from '../shared/shipping/shipping.service';
import { LoginPageComponent } from '../login-page/login-page.component';


@Component({
  selector: 'app-showshipping',
  templateUrl: './showshipping.component.html',
  styleUrls: ['./showshipping.component.css']
})
export class ShowshippingComponent implements OnInit {

  dataColumns: string[] = [ 'id','date', 'shipper' , 'receiver' , 'address' , 'agency' , 'postcode', 'trackingNo' , 'shippingstatus','update'];

    displayedColumns: string[] = [ 'No','date', 'agency','trackingNo', 'shippingstatus'];

    shippingInfo: Array<any>;
    getstatus: any = {
      shippingID:'',
      proposalId:''
    }

  constructor(private shippingService:ShippingService, private httpClient: HttpClient, private router:Router) { }
  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{
        this.shippingService.getShippingInfo().subscribe(data => {
          this.shippingInfo = data;
          console.log(this.shippingInfo);
        });

  }}

  save(shippingID,proposalId){
      this.httpClient.put('http://localhost:8080/updateShipping/'+ shippingID +'/2',this.getstatus)
        .subscribe(
            data => {
                alert('อัพเดทสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['show-shipping'])
            },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
                this.router.navigate(['show-shipping'])
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
