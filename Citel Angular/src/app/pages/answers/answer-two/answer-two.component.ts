import { Component } from '@angular/core';
import { BloodBankService } from 'src/app/service/blood-bank-service';

@Component({
  selector: 'app-answer-two',
  templateUrl: './answer-two.component.html',
  styleUrls: ['./answer-two.component.css']
})
export class AnswerTwoComponent {
  answerTwo = "Qual a média de IMC em cada faixa de idade de dez em dez anos?";
  resultAnswer = new Map<string, number>();

  constructor(private bloodBankService: BloodBankService) {}

  ngOnInit() {
    this.initializeData();
  }

  initializeData() {
    this.bloodBankService.perguntaDois().subscribe((result: Map<string, number>) => {
      this.resultAnswer = new Map<string, number>(Object.entries(result));
    });
  }
}
