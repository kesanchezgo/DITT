import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
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
    path: 'tabs',
    //loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
    loadChildren: () => import('./pages/tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'user-dashboard',
    loadChildren: () => import('./pages/user-dashboard/user-dashboard.module').then( m => m.UserDashboardPageModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./pages/participant-registration/participant-registration.module').then( m => m.ParticipantRegistrationPageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'dni-scanner',
    loadChildren: () => import('./pages/dni-scanner/dni-scanner.module').then( m => m.DniScannerPageModule)
  },
  {
    path: 'dni-scanner-ocr',
    loadChildren: () => import('./pages/dni-scanner-ocr/dni-scanner-ocr.module').then( m => m.DniScannerOcrPageModule)
  },
  {
    path: 'project-detail/:id',
    loadChildren: () => import('./pages/project-detail/project-detail.module').then(m => m.ProjectDetailPageModule)
  },
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
