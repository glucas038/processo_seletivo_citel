import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IClientResponseHome } from '../interfaces/iclient-response-home';
import { IClientResponseAllData } from '../interfaces/iclient-response-all-data';

@Injectable({
  providedIn: 'root'
})
export class BloodBankService {
  endpoint = 'banco-de-sangue';
  api = environment.api;

  constructor(private http: HttpClient) {}

  retornarTodosCandidatos(){
    return this.http.get<IClientResponseHome[]>(`${this.api}/${this.endpoint}`);
  }

  retornarUmCandidato(cpf: String){
    return this.http.get<IClientResponseAllData>(`${this.api}/${this.endpoint}/${cpf}`);
  }

  perguntaUm(){
    return this.http.get<Map<string, number>>(`${this.api}/${this.endpoint}/pergunta-1`);;
  }

  perguntaDois(){
    return this.http.get<Map<string, number>>(`${this.api}/${this.endpoint}/pergunta-2`);;
  }

  perguntaTres(){
    return this.http.get<Map<string, number>>(`${this.api}/${this.endpoint}/pergunta-3`);;
  }

  perguntaQuatro(){
    return this.http.get<Map<string, number>>(`${this.api}/${this.endpoint}/pergunta-4`);;
  }

  perguntaCinco(){
    return this.http.get<Map<string, number>>(`${this.api}/${this.endpoint}/pergunta-5`);;
  }
  
}
