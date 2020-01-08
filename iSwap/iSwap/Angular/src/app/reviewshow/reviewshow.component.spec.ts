import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewshowComponent } from './reviewshow.component';

describe('ReviewshowComponent', () => {
  let component: ReviewshowComponent;
  let fixture: ComponentFixture<ReviewshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
