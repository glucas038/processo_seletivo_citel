import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs';
import { BloodBankService } from 'src/app/service/blood-bank-service';

@Component({
  selector: 'app-answer-one',
  templateUrl: './answer-one.component.html',
  styleUrls: ['./answer-one.component.css']
})
export class AnswerOneComponent {

  answerOne = "Quantos candidatos em cada estado do Brasil temos na lista de Candidatos ?";

  resultAnswer: Map<string, number> = new Map();
  siglasEstados = new Map([
    ['AC', 'Acre'],
    ['AL', 'Alagoas'],
    ['AP', 'Amapá'],
    ['AM', 'Amazonas'],
    ['BA', 'Bahia'],
    ['CE', 'Ceará'],
    ['DF', 'Distrito Federal'],
    ['ES', 'Espírito Santo'],
    ['GO', 'Goiás'],
    ['MA', 'Maranhão'],
    ['MT', 'Mato Grosso'],
    ['MS', 'Mato Grosso do Sul'],
    ['MG', 'Minas Gerais'],
    ['PA', 'Pará'],
    ['PB', 'Paraíba'],
    ['PR', 'Paraná'],
    ['PE', 'Pernambuco'],
    ['PI', 'Piauí'],
    ['RJ', 'Rio de Janeiro'],
    ['RN', 'Rio Grande do Norte'],
    ['RS', 'Rio Grande do Sul'],
    ['RO', 'Rondônia'],
    ['RR', 'Roraima'],
    ['SC', 'Santa Catarina'],
    ['SP', 'São Paulo'],
    ['SE', 'Sergipe'],
    ['TO', 'Tocantins'],
  ]);

  constructor(private bloodBankService: BloodBankService, private route: ActivatedRoute) {}

  ngOnInit(){
    this.bloodBankService.perguntaUm().subscribe((result: Map<string, number>) => {
      this.resultAnswer = new Map<string, number>(Object.entries(result));
    });
  }

  converterSiglaEmEstados(sigla: string): string {
    return this.siglasEstados.get(sigla) || '';
  }
}
