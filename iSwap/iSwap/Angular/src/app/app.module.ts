import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ProposalComponent } from './proposal/proposal.component';
import { ToptoolbarComponent } from './toptoolbar/toptoolbar.component';
import { ProposalService} from './shared/proposal/proposal.service';
import { RegisterPageComponent } from './register-page/register-page.component';
import { ShowProfileComponent } from './show-profile/show-profile.component';
import { RegisService } from './shared/regis/regis.service';
import { LoginPageComponent } from './login-page/login-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProposalListComponent } from './proposal-list/proposal-list.component';
import { DeleteComponent } from './delete/delete.component';
import { AddItemService } from './shared/item/add-item.service';
import { ShowsComponent } from './shows/shows.component';
import { AddComponent } from './add/add.component';
import { ReviewComponent } from './review/review.component';
import { StarComponent } from './star/star.component';
import { ReviewshowComponent } from './reviewshow/reviewshow.component';
import { ReviewService } from './shared/review/review.service';
import { ShippingComponent } from './shipping/shipping.component';
import { ShowshippingComponent } from './showshipping/showshipping.component';
import { ShippingService } from './shared/shipping/shipping.service';
import { MeetingComponent } from './meeting/meeting.component';
import { MeetingshowComponent } from './meetingshow/meetingshow.component';
import { MeetingService } from './shared/meeting/meeting.service';


const appRoutes: Routes = [
  {path: '',  redirectTo: 'login', pathMatch: 'full'},
  {path: 'proposal/:itemId',component: ProposalComponent},
  {path: 'regis',component: RegisterPageComponent},
  {path: 'profile',component: ShowProfileComponent},
  {path: 'login',component: LoginPageComponent},
  {path: 'home',component: HomePageComponent},
  {path: 'proposal-list',component: ProposalListComponent},
  {path: 'add',component: AddComponent},
  {path: 'delete',component: DeleteComponent},
  {path: 'shows',component: ShowsComponent},
  {path: 'review/:proposalId',component:ReviewComponent},
  {path: 'reviewshow',component:ReviewshowComponent},
  {path: 'shipping/:id',component:ShippingComponent},
  {path: 'show-shipping',component:ShowshippingComponent},
  {path:'meeting/:id',component : MeetingComponent},
  {path:'meetingshow',component : MeetingshowComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ProposalComponent,
    ToptoolbarComponent,
    RegisterPageComponent,
    ShowProfileComponent,
    LoginPageComponent,
    HomePageComponent,
    ProposalListComponent,
    AddComponent,
    DeleteComponent,
    ShowsComponent,
    ReviewComponent,
    StarComponent,
    ReviewshowComponent,
    ShippingComponent,
    ShowshippingComponent,
    MeetingComponent,
    MeetingshowComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ProposalService,RegisService,AddItemService,ReviewService,ShippingService,MeetingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
