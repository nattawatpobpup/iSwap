import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProposalService } from '../shared/proposal/proposal.service';
import { Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';

@Component({
  selector: 'app-proposal',
  templateUrl: './proposal.component.html',
  styleUrls: ['./proposal.component.css']
})
export class ProposalComponent implements OnInit {
  userReceive : String;
  itemReceiveId : number;
  itemReceive : String;
  itemsOffer : Array<any>;
  options : Array<any>;
  ProposalData : any = {
    OfferItemSelect : '',
    DescriptionInput : '',
    OptionNameSelect : ''
  };

  constructor(private proposalService: ProposalService , private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    if(!LoginPageComponent.authentication){
      this.router.navigate(['login']);
      alert('กรุณาเข้าสู่ระบบ');
    }else{
    this.rout.params.subscribe(params => {
      this.itemReceiveId = +params['itemId'];
      console.log(this.itemReceiveId);
    });

    this.proposalService.getItemById(this.itemReceiveId).subscribe(data => {
      this.userReceive = data.user.username;
      this.itemReceive = data.itemName;
      console.log(this.userReceive,this.itemReceive);
    });

    this.proposalService.getTradeOption().subscribe(data => {
      this.options = data;
      console.log(this.options);
    });

    this.proposalService.getItem(LoginPageComponent.userIdLogin).subscribe(data => {
      this.itemsOffer = data;
      console.log(this.itemsOffer);
    });
    }
  }

  save() {
    if (this.ProposalData.OfferItemSelect === '' || this.ProposalData.OptionNameSelect === '') {
      alert('กรุณาเลือกสินค้าของคุณ และ เสนอวิธีการแลกเปลี่ยน');
    } else {
      if(this.ProposalData.DescriptionInput === ''){
        this.ProposalData.DescriptionInput = '---';
      }
      this.httpClient.post('http://localhost:8080/addProposal/'+this.itemReceiveId+'/'+this.ProposalData.OfferItemSelect+'/'+this.ProposalData.OptionNameSelect+'/1/'+this.ProposalData.DescriptionInput,this.ProposalData).subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['proposal-list']);
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

  update(proposalId){

  }
}
