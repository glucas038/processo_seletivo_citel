import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IClientResponseAllData } from 'src/app/interfaces/iclient-response-all-data';
import { BloodBankService } from 'src/app/service/blood-bank-service';

@Component({
  selector: 'app-view-one-donor',
  templateUrl: './view-one-donor.component.html',
  styleUrls: ['./view-one-donor.component.css']
})
export class ViewOneDonorComponent {
  donorForm = new FormGroup({
    nome: new FormControl('', Validators.required),
    cpf: new FormControl('', Validators.required),
    rg: new FormControl('', Validators.required),
    data_nasc: new FormControl('', Validators.required),
    sexo: new FormControl('', Validators.required),
    mae: new FormControl('', Validators.required),
    pai: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    cep: new FormControl('', Validators.required),
    endereco: new FormControl('', Validators.required),
    numero: new FormControl(0, Validators.required),
    bairro: new FormControl('', Validators.required),
    cidade: new FormControl('', Validators.required),
    estado: new FormControl('', Validators.required),
    telefone_fixo: new FormControl('', Validators.required),
    celular: new FormControl('', Validators.required),
    altura: new FormControl(0, Validators.required),
    peso: new FormControl(0, Validators.required),
    tipo_sanguineo: new FormControl('', Validators.required),
  })

  constructor(private bloodBankService: BloodBankService, private route: ActivatedRoute){};

  ngOnInit(){
    const cpf = String(this.route.snapshot.paramMap.get('cpf'));

    if(cpf){
      this.bloodBankService.retornarUmCandidato(cpf).subscribe((candidato: IClientResponseAllData) => {
        this.donorForm.setValue({
          nome: candidato.nome,
          cpf: candidato.cpf,
          rg: candidato.rg,
          data_nasc: candidato.data_nasc,
          sexo: candidato.sexo,
          mae: candidato.mae,
          pai: candidato.pai,
          email: candidato.email,
          cep: candidato.cep,
          endereco: candidato.endereco,
          numero: candidato.numero,
          bairro: candidato.bairro,
          cidade: candidato.cidade,
          estado: candidato.estado,
          telefone_fixo: candidato.telefone_fixo,
          celular: candidato.celular,
          altura: candidato.altura,
          peso: candidato.peso,
          tipo_sanguineo: candidato.tipo_sanguineo
        })
      })
    }
  }

}
