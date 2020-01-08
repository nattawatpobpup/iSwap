import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowshippingComponent } from './showshipping.component';

describe('ShowshippingComponent', () => {
  let component: ShowshippingComponent;
  let fixture: ComponentFixture<ShowshippingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowshippingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowshippingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
