import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { DeviceControlPageRoutingModule } from './device-control-routing.module';

import { DeviceControlPage } from './device-control.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    DeviceControlPageRoutingModule
  ],
  declarations: [DeviceControlPage]
})
export class DeviceControlPageModule {}
