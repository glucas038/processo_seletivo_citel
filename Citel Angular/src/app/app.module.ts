import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { ViewAllDonorComponent } from './pages/blood-bank/view-all-donor/view-all-donor.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AnswerOneComponent } from './pages/answers/answer-one/answer-one.component';
import { AnswerTwoComponent } from './pages/answers/answer-two/answer-two.component';
import { AnswerThreeComponent } from './pages/answers/answer-three/answer-three.component';
import { AnswerFourComponent } from './pages/answers/answer-four/answer-four.component';
import { AnswerFiveComponent } from './pages/answers/answer-five/answer-five.component';
import { ViewOneDonorComponent } from './pages/blood-bank/view-one-donor/view-one-donor.component';
import { BackButtonComponent } from './components/back-button/back-button.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ViewAllDonorComponent,
    AnswerOneComponent,
    AnswerTwoComponent,
    AnswerThreeComponent,
    AnswerFourComponent,
    AnswerFiveComponent,
    ViewOneDonorComponent,
    BackButtonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
