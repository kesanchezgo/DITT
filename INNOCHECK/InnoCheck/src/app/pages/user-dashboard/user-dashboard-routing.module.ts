import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UserDashboardPage } from './user-dashboard.page';

const routes: Routes = [
  {
    path: 'user-dashboard',
    component: UserDashboardPage,
    children: [
      {
        path: 'tab1',
        //loadChildren: () => import('../../pages/attendance-control/attendance-control.module').then(m => m.AttendanceControlPageModule)
        loadChildren: () => import('../../tab1/tab1.module').then(m => m.Tab1PageModule)
      },
      {
        path: 'tab2',
        loadChildren: () => import('../../tab2/tab2.module').then(m => m.Tab2PageModule)
      },
      {
        path: 'tab3',
        loadChildren: () => import('../../tab3/tab3.module').then(m => m.Tab3PageModule)
      },
      {
        path: '',
        redirectTo: 'tab1',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: 'user-dashboard/tab1',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserDashboardPageRoutingModule {}


