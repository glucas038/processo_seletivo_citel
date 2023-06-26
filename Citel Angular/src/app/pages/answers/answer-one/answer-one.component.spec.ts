import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerOneComponent } from './answer-one.component';

describe('AnswerOneComponent', () => {
  let component: AnswerOneComponent;
  let fixture: ComponentFixture<AnswerOneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnswerOneComponent]
    });
    fixture = TestBed.createComponent(AnswerOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
