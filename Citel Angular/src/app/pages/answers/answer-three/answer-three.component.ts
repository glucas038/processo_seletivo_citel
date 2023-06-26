import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodBankService } from 'src/app/service/blood-bank-service';

@Component({
  selector: 'app-answer-three',
  templateUrl: './answer-three.component.html',
  styleUrls: ['./answer-three.component.css']
})
export class AnswerThreeComponent {

  answerThree = "Qual o percentual de obesos entre homens e entre as mulheres ?";

  resultAnswer: Map<string, number> = new Map();
  

  constructor(private bloodBankService: BloodBankService, private route: ActivatedRoute) {}

  ngOnInit(){
    this.bloodBankService.perguntaTres().subscribe((result: Map<string, number>) => {
      this.resultAnswer = new Map<string, number>(Object.entries(result));
    });
  }

}
