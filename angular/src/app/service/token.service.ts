import { TokenPayload } from './../model/TokenPayload';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import * as decode from 'jwt-decode';

const TOKEN_KEY = 'AuthToken';
const EMAIL_KEY = 'email';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  private email = new Subject<String>();
  public emailEmitter = this.email.asObservable();

  constructor(public router: Router) {
    // window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.setItem(EMAIL_KEY, token);
    const tokenPayload: TokenPayload = decode(token);
    this.saveEmail(tokenPayload.sub);
  }

  signOut() {
    window.sessionStorage.clear();
    this.emailEmitChange(null);
    this.router.navigate(['']);
  }

  public checkIsLoggedIn(): boolean {
    if (sessionStorage.getItem(TOKEN_KEY)) 
      return true; 
    return false;
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveEmail(email: string) {
    window.sessionStorage.setItem(EMAIL_KEY, email);
    this.emailEmitChange(email);
  }

  public getEmail(): string {
    return sessionStorage.getItem(EMAIL_KEY);
  }

  emailEmitChange(email: String) {
    this.email.next(email);
  }
}
