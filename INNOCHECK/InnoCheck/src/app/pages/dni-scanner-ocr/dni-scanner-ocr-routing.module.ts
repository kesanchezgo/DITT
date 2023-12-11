import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DniScannerOcrPage } from './dni-scanner-ocr.page';

const routes: Routes = [
  {
    path: '',
    component: DniScannerOcrPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DniScannerOcrPageRoutingModule {}
