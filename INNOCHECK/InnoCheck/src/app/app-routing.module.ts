import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./pages/tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'attendance-control',
    loadChildren: () => import('./pages/attendance-control/attendance-control.module').then( m => m.AttendanceControlPageModule)
  },
  {
    path: 'device-control',
    loadChildren: () => import('./pages/device-control/device-control.module').then( m => m.DeviceControlPageModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'user-dashboard',
    loadChildren: () => import('./pages/user-dashboard/user-dashboard.module').then( m => m.UserDashboardPageModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./pages/participant-registration/participant-registration.module').then( m => m.ParticipantRegistrationPageModule)
  }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
