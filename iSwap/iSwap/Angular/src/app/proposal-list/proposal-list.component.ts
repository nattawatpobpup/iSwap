import { Component, OnInit } from '@angular/core';
import { ProposalService } from '../shared/proposal/proposal.service';
import { Router } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';


@Component({
  selector: 'app-proposal-list',
  templateUrl: './proposal-list.component.html',
  styleUrls: ['./proposal-list.component.css']
})
export class ProposalListComponent implements OnInit {
  dataForReceiver: string[] = ['no','itemReceiveName','itemOfferName','userOfferName','description','option','confirm'];
  dataForOffering: string[] = ['no','itemOfferName','itemReceiveName','userReceiveName','description','option','status'];
  dataForOffered: string[] = ['no','itemOfferName','itemReceiveName','userReceiveName','description','option','review'];
  ProposalReceiver: Array<any>;
  ProposalOffering: Array<any>;
  ProposalOffered: Array<any>;
  constructor(private proposalService:ProposalService,private router: Router) { }

  ngOnInit() {
  if(!LoginPageComponent.authentication){
      this.router.navigate(['login']);
      alert('กรุณาเข้าสู่ระบบ');
    }else{
      this.proposalService.getProposalReceiver(LoginPageComponent.usernameLogin).subscribe(data => {
        this.ProposalReceiver = data;
        console.log(this.ProposalReceiver);
      });
      this.proposalService.getProposalOffer(LoginPageComponent.usernameLogin,1).subscribe(data => {
        this.ProposalOffering = data;
        console.log(this.ProposalOffering);
      });
      this.proposalService.getProposalOffer(LoginPageComponent.usernameLogin,2).subscribe(data => {
        this.ProposalOffered = data;
        console.log(this.ProposalOffered);
      });
  }
  }

  confirm(element): void {
    if(element.tradeOption.id === 1){
      this.router.navigate(['meeting/' + element.id ]);
    }else if(element.tradeOption.id === 2){
      this.router.navigate(['shipping/' + element.id]);
    }
  }

  review(element): void{
    this.router.navigate(['review/' + element.id]);
  }
}
