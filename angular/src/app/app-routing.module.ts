import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginPageComponent} from './pages/login/login.component';
import { LoginGuardService } from './service/login-guard.service';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RouteGuardService } from './service/route-guard.service';


const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'home', component:HomePageComponent, canActivate: [RouteGuardService]},
  {path:'login', component:LoginPageComponent,canActivate: [LoginGuardService]},
  {path:'signup', component:RegistrationPageComponent,canActivate: [LoginGuardService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
