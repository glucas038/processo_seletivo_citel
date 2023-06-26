import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodBankService } from 'src/app/service/blood-bank-service';

@Component({
  selector: 'app-answer-four',
  templateUrl: './answer-four.component.html',
  styleUrls: ['./answer-four.component.css']
})
export class AnswerFourComponent {

  answerFour = "Qual a média de idade para cada tipo sanguíneo?";

  resultAnswer: Map<string, number> = new Map();
  

  constructor(private bloodBankService: BloodBankService, private route: ActivatedRoute) {}

  ngOnInit(){
    this.bloodBankService.perguntaQuatro().subscribe((result: Map<string, number>) => {
      this.resultAnswer = new Map<string, number>(Object.entries(result));
    });
  }

}
