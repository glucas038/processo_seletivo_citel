import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ViewAllDonorComponent } from './pages/blood-bank/view-all-donor/view-all-donor.component';
import { AnswerOneComponent } from './pages/answers/answer-one/answer-one.component';
import { AnswerTwoComponent } from './pages/answers/answer-two/answer-two.component';
import { AnswerThreeComponent } from './pages/answers/answer-three/answer-three.component';
import { AnswerFourComponent } from './pages/answers/answer-four/answer-four.component';
import { AnswerFiveComponent } from './pages/answers/answer-five/answer-five.component';
import { ViewOneDonorComponent } from './pages/blood-bank/view-one-donor/view-one-donor.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'pagina-principal'},
  { path: 'pagina-principal', component: HomeComponent},
  { path: 'candidatos', component: ViewAllDonorComponent},
  { path: 'candidatos/pergunta-1', component: AnswerOneComponent},
  { path: 'candidatos/pergunta-2', component: AnswerTwoComponent},
  { path: 'candidatos/pergunta-3', component: AnswerThreeComponent},
  { path: 'candidatos/pergunta-4', component: AnswerFourComponent},
  { path: 'candidatos/pergunta-5', component: AnswerFiveComponent},
  { path: 'candidatos/ver/:cpf', component: ViewOneDonorComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
