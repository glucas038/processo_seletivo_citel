import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { IClientResponseHome } from 'src/app/interfaces/iclient-response-home'
import { BloodBankService } from 'src/app/service/blood-bank-service';


@Component({
  selector: 'app-view-all-donor',
  templateUrl: './view-all-donor.component.html',
  styleUrls: ['./view-all-donor.component.css']
})
export class ViewAllDonorComponent {

 allDonorForm = new FormGroup({
  cpf: new FormControl('', Validators.required),
  name: new FormControl('', Validators.required),
  email: new FormControl('', Validators.required)
 })

 allDonors: IClientResponseHome[] = [];
 
 constructor(private bloodBankService: BloodBankService, private route: ActivatedRoute){};

 
ngOnInit(){
  console.log("Teste");
  this.bloodBankService.retornarTodosCandidatos().subscribe((result: IClientResponseHome[]) => {
    this.allDonors = result;
  });
}




}
 
