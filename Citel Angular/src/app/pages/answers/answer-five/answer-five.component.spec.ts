import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerFiveComponent } from './answer-five.component';

describe('AnswerFiveComponent', () => {
  let component: AnswerFiveComponent;
  let fixture: ComponentFixture<AnswerFiveComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnswerFiveComponent]
    });
    fixture = TestBed.createComponent(AnswerFiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
