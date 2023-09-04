import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AttendanceControlPageRoutingModule } from './attendance-control-routing.module';

import { AttendanceControlPage } from './attendance-control.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AttendanceControlPageRoutingModule
  ],
  declarations: [AttendanceControlPage]
})
export class AttendanceControlPageModule {}
