import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerThreeComponent } from './answer-three.component';

describe('AnswerThreeComponent', () => {
  let component: AnswerThreeComponent;
  let fixture: ComponentFixture<AnswerThreeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnswerThreeComponent]
    });
    fixture = TestBed.createComponent(AnswerThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
