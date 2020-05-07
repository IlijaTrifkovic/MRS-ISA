import * as tslib_1 from "tslib";
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
var AuthService = /** @class */ (function () {
    function AuthService(http) {
        this.http = http;
        this.url = environment.baseUrl;
        this.loginUrl = '/login';
        this.signupUrl = '/signup';
    }
    AuthService.prototype.login = function (loginInfo) {
        return this.http.post(this.url + this.loginUrl, loginInfo, environment.httpOptions);
    };
    AuthService.prototype.signup = function (signupInfo) {
        return this.http.post(this.url + this.signupUrl, signupInfo, environment.httpOptions);
    };
    AuthService.prototype.helloTest = function () {
        return this.http.get(this.url + "/hello");
    };
    AuthService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], AuthService);
    return AuthService;
}());
export { AuthService };
//# sourceMappingURL=auth.service.js.map