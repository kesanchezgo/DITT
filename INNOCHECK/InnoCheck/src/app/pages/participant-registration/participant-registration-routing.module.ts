import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ParticipantRegistrationPage } from './participant-registration.page';

const routes: Routes = [
  {
    path: '',
    component: ParticipantRegistrationPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ParticipantRegistrationPageRoutingModule {}
