import * as tslib_1 from "tslib";
import { TokenService } from '../service/token.service';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
var ResponseErrorInterceptor = /** @class */ (function () {
    function ResponseErrorInterceptor(router, tokenService) {
        this.router = router;
        this.tokenService = tokenService;
    }
    ResponseErrorInterceptor.prototype.intercept = function (request, next) {
        var _this = this;
        return next.handle(request).pipe(catchError(function (err) {
            if (err.status === 401) {
                _this.tokenService.signOut();
                _this.router.navigate(['']);
            }
            var error = err.error.message || err.statusText;
            return throwError(err);
        }));
    };
    ResponseErrorInterceptor = tslib_1.__decorate([
        Injectable(),
        tslib_1.__metadata("design:paramtypes", [Router, TokenService])
    ], ResponseErrorInterceptor);
    return ResponseErrorInterceptor;
}());
export { ResponseErrorInterceptor };
//# sourceMappingURL=resonpse-error-interceptor.js.map