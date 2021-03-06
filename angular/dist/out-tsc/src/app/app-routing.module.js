import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginPageComponent } from './pages/login/login.component';
import { LoginGuardService } from './service/login-guard.service';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { RouteGuardService } from './service/route-guard.service';
import { ProfilePageComponent } from './pages/home-page/profile-page/profile-page.component';
import { ChangePasswordPageComponent } from './pages/home-page/change-password-page/change-password-page.component';
import { ListOfClinicsComponent } from './pages/home-page/list-of-clinics/list-of-clinics.component';
import { ClinicProfileComponent } from './pages/home-page/clinic-profile/clinic-profile.component';
import { MedicalRecordComponent } from './pages/home-page/medical-record/medical-record.component';
var routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomePageComponent, canActivate: [RouteGuardService], children: [
            { path: '', component: ListOfClinicsComponent },
            { path: 'clinic-profile/:id', component: ClinicProfileComponent },
            { path: 'medical-record', component: MedicalRecordComponent },
            { path: 'profile', component: ProfilePageComponent },
            { path: 'changePassword', component: ChangePasswordPageComponent },
        ] },
    { path: 'login', component: LoginPageComponent, canActivate: [LoginGuardService] },
    { path: 'signup', component: RegistrationPageComponent, canActivate: [LoginGuardService] },
    { path: '**', redirectTo: 'home', pathMatch: 'full' },
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());
export { AppRoutingModule };
//# sourceMappingURL=app-routing.module.js.map