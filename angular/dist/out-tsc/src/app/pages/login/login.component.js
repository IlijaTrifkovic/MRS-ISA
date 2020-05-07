import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { TokenService } from './../../service/token.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from './../../authentication/auth.service';
var LoginPageComponent = /** @class */ (function () {
    function LoginPageComponent(formBuilder, authHttpService, tokenService, router) {
        this.formBuilder = formBuilder;
        this.authHttpService = authHttpService;
        this.tokenService = tokenService;
        this.router = router;
        this.statusMessage = '';
        this.loginStat = false;
        this.mesStat = false;
        this.loginForm = formBuilder.group({
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]]
        });
    }
    LoginPageComponent.prototype.ngOnInit = function () {
    };
    LoginPageComponent.prototype.onLogin = function () {
        var _this = this;
        if (!this.loginForm.valid) {
            this.statusMessage = "Unesite validne podatke!";
            this.mesStat = true;
            return;
        }
        this.statusMessage = "Prijavljivanje na sistem...";
        this.loginStat = true;
        this.mesStat = true;
        var loginInfo = this.loginForm.value;
        this.authHttpService.login(loginInfo).subscribe(function (data) {
            _this.tokenService.saveToken(data.token);
            _this.loginStat = false;
            _this.mesStat = false;
            _this.router.navigate(['']);
        }, function (error) {
            console.log(error);
            _this.loginStat = false;
            if (error.error.details)
                _this.statusMessage = error.error.details;
            else
                _this.statusMessage = "Greška, pokušajte ponovo!";
        });
    };
    LoginPageComponent = tslib_1.__decorate([
        Component({
            selector: 'app-login',
            templateUrl: './login.component.html',
            styleUrls: ['./login.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [FormBuilder, AuthService,
            TokenService, Router])
    ], LoginPageComponent);
    return LoginPageComponent;
}());
export { LoginPageComponent };
//# sourceMappingURL=login.component.js.map