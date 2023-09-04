import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ParticipantRegistrationPageRoutingModule } from './participant-registration-routing.module';

import { ParticipantRegistrationPage } from './participant-registration.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ParticipantRegistrationPageRoutingModule
  ],
  declarations: [ParticipantRegistrationPage]
})
export class ParticipantRegistrationPageModule {}
