import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOneDonorComponent } from './view-one-donor.component';

describe('ViewOneDonorComponent', () => {
  let component: ViewOneDonorComponent;
  let fixture: ComponentFixture<ViewOneDonorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewOneDonorComponent]
    });
    fixture = TestBed.createComponent(ViewOneDonorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
