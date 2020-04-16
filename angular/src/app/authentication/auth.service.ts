import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url = environment.baseUrl;
  loginUrl = '/login';

  constructor(private http: HttpClient) { }

  login(loginInfo): Observable<any> {
    return this.http.post(this.url + this.loginUrl, loginInfo, environment.httpOptions);
  }
}