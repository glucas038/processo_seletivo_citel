import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodBankService } from 'src/app/service/blood-bank-service';

@Component({
  selector: 'app-answer-five',
  templateUrl: './answer-five.component.html',
  styleUrls: ['./answer-five.component.css']
})
export class AnswerFiveComponent {
  answerFive = "Quantidade de possiveis doadores para cada tipo sanguineo?";

  resultAnswer: Map<string, number> = new Map();
  

  constructor(private bloodBankService: BloodBankService, private route: ActivatedRoute) {}

  ngOnInit(){
    this.bloodBankService.perguntaCinco().subscribe((result: Map<string, number>) => {
      this.resultAnswer = new Map<string, number>(Object.entries(result));
    });
  }
}
