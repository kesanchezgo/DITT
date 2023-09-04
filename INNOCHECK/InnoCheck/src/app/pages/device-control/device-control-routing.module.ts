import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DeviceControlPage } from './device-control.page';

const routes: Routes = [
  {
    path: '',
    component: DeviceControlPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DeviceControlPageRoutingModule {}
