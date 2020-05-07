import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { TokenService } from './../../service/token.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from './../../authentication/auth.service';
var RegistrationPageComponent = /** @class */ (function () {
    function RegistrationPageComponent(formBuilder, authHttpService, tokenService, router) {
        this.formBuilder = formBuilder;
        this.authHttpService = authHttpService;
        this.tokenService = tokenService;
        this.router = router;
        this.statusMessage = '';
        this.submit = false;
        this.mesInfo = false;
        this.signupForm = formBuilder.group({
            firstName: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
            lastName: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
            email: ['', [Validators.required, Validators.email]],
            phoneNumber: ['', [Validators.pattern("^[0-9]{0,20}$")]],
            jmbg: ['', [Validators.required, Validators.pattern("^[0-9]{13}$")]],
            lbo: ['', [Validators.required, Validators.pattern("^[0-9]{11}$")]],
            zk: ['', [Validators.required, Validators.pattern("^[0-9]{11}$")]],
            address: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(30)]],
            city: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
            country: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
            password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]],
            password2: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]],
        });
    }
    RegistrationPageComponent.prototype.ngOnInit = function () {
    };
    RegistrationPageComponent.prototype.onSubmit = function () {
        var _this = this;
        if (!this.signupForm.valid || !this.isPasswordValid()) {
            this.statusMessage = "Unesite validne podatke!";
            this.mesInfo = true;
            return;
        }
        this.submit = true;
        this.statusMessage = "Slanje zahtjeva za registraciju...";
        this.mesInfo = true;
        var loginInfo = this.signupForm.value;
        this.authHttpService.signup(loginInfo).subscribe(function (data) {
            _this.submit = false;
            _this.mesInfo = false;
            alert("Zahtjev za registraciju je poslat.\nObavještenje će biti dostavljeno na email: " +
                _this.signupForm.controls['email'].value + ".");
            _this.router.navigate(['/login']);
        }, function (error) {
            _this.submit = false;
            if (!error.error.details)
                _this.statusMessage = "Greška, pokušajte ponovo!";
            else
                _this.statusMessage = error.error.details;
        });
    };
    RegistrationPageComponent.prototype.isFieldValid = function (name) {
        return !(this.signupForm.controls[name].invalid && (this.signupForm.controls[name].dirty || this.signupForm.controls[name].touched));
    };
    RegistrationPageComponent.prototype.isPasswordValid = function () {
        return this.signupForm.controls['password'].value === this.signupForm.controls['password2'].value;
    };
    RegistrationPageComponent = tslib_1.__decorate([
        Component({
            selector: 'app-registration-page',
            templateUrl: './registration-page.component.html',
            styleUrls: ['./registration-page.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [FormBuilder, AuthService,
            TokenService, Router])
    ], RegistrationPageComponent);
    return RegistrationPageComponent;
}());
export { RegistrationPageComponent };
//# sourceMappingURL=registration-page.component.js.map