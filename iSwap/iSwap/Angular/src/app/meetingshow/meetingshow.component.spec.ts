import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeetingshowComponent } from './meetingshow.component';
import {MatTableModule} from '@angular/material/table';

describe('MeetingshowComponent', () => {
  let component: MeetingshowComponent;
  let fixture: ComponentFixture<MeetingshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeetingshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeetingshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
