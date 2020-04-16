import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginPageComponent} from './pages/login/login.component';
import { LoginGuardService } from './service/login-guard.service';


const routes: Routes = [
  {path:'login', component:LoginPageComponent,canActivate: [LoginGuardService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
