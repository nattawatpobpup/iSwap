import { Component, OnInit } from '@angular/core';
import { ShippingService } from '../shared/shipping/shipping.service';
import { HttpClient} from '@angular/common/http';
import { MatDialogRef } from '@angular/material';
import { Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';


@Component({
  selector: 'app-shipping',
  templateUrl: './shipping.component.html',
  styleUrls: ['./shipping.component.css']
})

export class ShippingComponent implements OnInit {

  provinces: Array<any>;
  shippingstatuses: Array<any>;
  proposal:number;
  shippingData: any = {
    shipperInput: '',
    receiverInput: '',
    dateInput: '',
    addressInput:'',
    postcodeInput:'',
    trackingNoInput:'',
    agencyInput:'',
    provincenameSelect:'',
    shippingstatusesSelect:''
  };

  constructor(private router: Router, private rout: ActivatedRoute,private shippingService:ShippingService , private httpClient: HttpClient ) { }

  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{
    this.rout.params.subscribe(params => {
        this.proposal = +params['id'];
        console.log(this.proposal);
    });

    this.shippingService.getProvince().subscribe(data =>{
      this.provinces = data;
      console.log(this.provinces);
    })

    this.shippingService.getShippingStatus().subscribe(data =>{
      this.shippingstatuses = data;
      console.log(this.shippingstatuses);
    })
  }}
  save(){
    if( this.shippingData.shipperInput ===''||
    this.shippingData.receiverInput===''||
    this.shippingData.dateInput===''||
    this.shippingData.addressInput===''||
    this.shippingData.postcodeInput===''||
    this.shippingData.trackingNoInput===''||
    this.shippingData.agencyInput===''){
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else{
    this.httpClient.post('http://localhost:8080/newShipping/' + this.shippingData.provincenameSelect + '/1/' + this.shippingData.dateInput + '/' + this.proposal ,this.shippingData).subscribe(
      data => {
        alert('ยืนยันการจัดส่งเสร็จเรียบร้อย');
        console.log('PUT Request is successful', data);
        this.router.navigate(['show-shipping']);
      },
      error => {
        alert('เกิดข้อผิดพลาด');
        console.log('Error', error);
      });
    }

  }
  
}


