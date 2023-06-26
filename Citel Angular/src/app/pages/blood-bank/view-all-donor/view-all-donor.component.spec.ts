import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllDonorComponent } from './view-all-donor.component';

describe('ViewAllDonorComponent', () => {
  let component: ViewAllDonorComponent;
  let fixture: ComponentFixture<ViewAllDonorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewAllDonorComponent]
    });
    fixture = TestBed.createComponent(ViewAllDonorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
