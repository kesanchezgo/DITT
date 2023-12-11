import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { DniScannerOcrPageRoutingModule } from './dni-scanner-ocr-routing.module';

import { DniScannerOcrPage } from './dni-scanner-ocr.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    DniScannerOcrPageRoutingModule
  ],
  declarations: [DniScannerOcrPage]
})
export class DniScannerOcrPageModule {}
