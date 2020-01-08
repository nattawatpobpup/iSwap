import { Component, OnInit } from '@angular/core';
import { RegisService } from '../shared/regis/regis.service';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {
  provinces: Array<any>;
  genders: Array<any>;
  careers:  Array<any>;
  registerData: any = {
    firstnameInput: '',
    lastnameInput: '',
    brithdaySelect: '',
    gendertypeSelect:'',
    careernameSelect:'',
    usernameInput:'',
    passwordInput:'',
    provincenameSelect:'',
    addressInput:'',
    postcodeInput:'',
    phonenumInput:''
  };
  constructor(private regisService:RegisService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.regisService.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

    this.regisService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });

    this.regisService.getCareer().subscribe(data => {
      this.careers = data;
      console.log(this.careers);
    });
  }

  save(){
    console.log(this.registerData.brithdaySelect);
    if(this.registerData.gendertypeSelect ===''||
    this.registerData.careernameSelect ===''||
    this.registerData.provincenameSelect ===''){
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else{
      this.httpClient.post('http://localhost:8080/Regis/' + this.registerData.gendertypeSelect + '/' +
                            this.registerData.careernameSelect + '/' + this.registerData.provincenameSelect + '/' + this.registerData.brithdaySelect ,this.registerData)
      .subscribe(
          data => {
              alert('Request is successful');
              console.log('PUT Request is successful', data);

          },
          error => {
              alert('Request is not successful');
              console.log('Rrror', error);
          }
      );
    }
  }




}
