import { TokenService } from '../service/token.service';
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()
export class ResponseErrorInterceptor implements HttpInterceptor {
    constructor(private router: Router, private tokenService: TokenService) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if (err.status === 401) {
              this.tokenService.signOut();
              this.router.navigate(['']);
            }
            const error = err.error.message || err.statusText;
            return throwError(err);
        }));
    }
}
