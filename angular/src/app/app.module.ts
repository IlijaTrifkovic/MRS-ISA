import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './pages/login/login.component';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtInterceptor } from './interceptor/jwt-interceptor';
import { ResponseErrorInterceptor } from './interceptor/resonpse-error-interceptor';

import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './pages/basic-ui/footer/footer.component';
import { NavigationComponent } from './pages/basic-ui/navigation/navigation.component';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProfilePageComponent } from './pages/home-page/profile-page/profile-page.component';
import { ChangePasswordPageComponent } from './pages/home-page/change-password-page/change-password-page.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegistrationPageComponent,
    HomePageComponent,
    FooterComponent,
    NavigationComponent,
    ProfilePageComponent,
    ProfilePageComponent,
    ChangePasswordPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ResponseErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
