import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerFourComponent } from './answer-four.component';

describe('AnswerFourComponent', () => {
  let component: AnswerFourComponent;
  let fixture: ComponentFixture<AnswerFourComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnswerFourComponent]
    });
    fixture = TestBed.createComponent(AnswerFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
