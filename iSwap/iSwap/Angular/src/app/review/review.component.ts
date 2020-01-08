import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../shared/review/review.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { throwMatDialogContentAlreadyAttachedError } from '@angular/material';
import { Router, RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';


@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  levels : Array<any>;
  private static reviewID:any;
  user: Array<any>;
  review:object;
  starCount: number;
  color: string;
  proposal: Array<any>;
  levelIdSelect : number = 0;
  propId: number = 0;
  comments: string = '';
  rating: number = 0;
  userFirstname:string;
  constructor(private service: ReviewService, private httpClient: HttpClient, private router: Router,private rout: ActivatedRoute) {

  }

  ngOnInit() {
  if(!LoginPageComponent.authentication){
        this.router.navigate(['login']);
        alert('กรุณาเข้าสู่ระบบ');
      }else{

    this.service.getUser(LoginPageComponent.userIdLogin).subscribe(data => {
      this.user = data;
      this.userFirstname = data.firstname;
      console.log(this.user);
      console.log(this.userFirstname);
    });


    this.service.getLevel().subscribe(data => {
      this.levels = data;
      console.log(this.levels);
    });

    this.rout.params.subscribe(params => {
      this.propId = +params['proposalId'];
      console.log(this.propId);
    });

    this.service.getProposal(this.propId).subscribe(data => {
      this.proposal = data;
      console.log(this.proposal);
    });

  }}

  onRatingChanged(rating) {
    console.log(rating);
    this.rating = rating;
  }

  public static getReviewId(): number {
    return this.reviewID;
  }

  save() {

    if( this.levelIdSelect===0 || this.rating=== 0 || this.comments===''){
      alert('กรอกข้อมูลไม่ครบ');
    }else{
      this.service.postReview(LoginPageComponent.userIdLogin,this.levelIdSelect,this.propId,this.rating,this.comments).subscribe(data => {
          console.log(data);
          ReviewComponent.reviewID = data.review_id;
          console.log('PUT Request is successful', data);
          this.router.navigate(['reviewshow']);
        },
          error => {
            console.log('Error', error);
          }
        );

    }
  }
}
