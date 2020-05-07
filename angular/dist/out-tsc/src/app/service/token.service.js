import * as tslib_1 from "tslib";
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import * as decode from 'jwt-decode';
import { ClinicListService } from './clinic-list.service';
var TOKEN_KEY = 'AuthToken';
var EMAIL_KEY = 'email';
var TokenService = /** @class */ (function () {
    function TokenService(router, clinicListService) {
        this.router = router;
        this.clinicListService = clinicListService;
        this.email = new Subject();
        this.emailEmitter = this.email.asObservable();
        // window.sessionStorage.clear();
    }
    TokenService.prototype.saveToken = function (token) {
        window.sessionStorage.setItem(TOKEN_KEY, token);
        var tokenPayload = decode(token);
        this.saveEmail(tokenPayload.sub);
    };
    TokenService.prototype.signOut = function () {
        window.sessionStorage.clear();
        this.emailEmitChange(null);
        this.clinicListService.setDefaultPageValue();
        this.router.navigate(["/login"]);
    };
    TokenService.prototype.checkIsLoggedIn = function () {
        if (sessionStorage.getItem(TOKEN_KEY))
            return true;
        return false;
    };
    TokenService.prototype.getToken = function () {
        return sessionStorage.getItem(TOKEN_KEY);
    };
    TokenService.prototype.saveEmail = function (email) {
        window.sessionStorage.setItem(EMAIL_KEY, email);
        this.emailEmitChange(email);
    };
    TokenService.prototype.getEmail = function () {
        return sessionStorage.getItem(EMAIL_KEY);
    };
    TokenService.prototype.emailEmitChange = function (email) {
        this.email.next(email);
    };
    TokenService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [Router, ClinicListService])
    ], TokenService);
    return TokenService;
}());
export { TokenService };
//# sourceMappingURL=token.service.js.map