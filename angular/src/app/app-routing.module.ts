import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginPageComponent} from './pages/login/login.component';
import { LoginGuardService } from './service/login-guard.service';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RouteGuardService } from './service/route-guard.service';
import { ProfilePageComponent } from './pages/home-page/profile-page/profile-page.component';
import { ChangePasswordPageComponent } from './pages/home-page/change-password-page/change-password-page.component';


const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'home', component:HomePageComponent, canActivate: [RouteGuardService] ,children:[
    {path:'profile', component:ProfilePageComponent},
    {path:'changePassword', component:ChangePasswordPageComponent},
  ]},
  {path:'login', component:LoginPageComponent,canActivate: [LoginGuardService]},
  {path:'signup', component:RegistrationPageComponent,canActivate: [LoginGuardService]},
  {path:'**', redirectTo:'home', pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
