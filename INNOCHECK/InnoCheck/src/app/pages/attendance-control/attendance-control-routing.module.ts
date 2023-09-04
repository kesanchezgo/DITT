import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AttendanceControlPage } from './attendance-control.page';

const routes: Routes = [
  {
    path: '',
    component: AttendanceControlPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AttendanceControlPageRoutingModule {}
