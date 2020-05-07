import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { PatientRestService } from 'src/app/service/patient-rest.service';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';
var ChangePasswordPageComponent = /** @class */ (function () {
    function ChangePasswordPageComponent(formBuilder, patientService, router, tokenService) {
        this.formBuilder = formBuilder;
        this.patientService = patientService;
        this.router = router;
        this.tokenService = tokenService;
        this.statusMessage = '';
        this.mesInfo = false;
        this.submit = false;
        this.changePasswordForm = formBuilder.group({
            oldPassword: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]],
            newPassword: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]],
            newPassword2: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(25)]],
        });
    }
    ChangePasswordPageComponent.prototype.ngOnInit = function () {
    };
    ChangePasswordPageComponent.prototype.onSubmit = function () {
        var _this = this;
        if (!this.changePasswordForm.valid || !this.isPasswordValid()) {
            this.statusMessage = "Unesite validne podatke!";
            this.mesInfo = true;
            return;
        }
        this.submit = true;
        this.statusMessage = "Slanje zahtjeva za registraciju...";
        this.mesInfo = true;
        var passwordInfo = this.changePasswordForm.value;
        this.patientService.changePassword(passwordInfo).subscribe(function (data) {
            _this.tokenService.saveToken(data.token);
            _this.submit = false;
            _this.mesInfo = false;
            _this.router.navigate(['/home/profile']);
        }, function (error) {
            _this.submit = false;
            if (!error.error.details)
                _this.statusMessage = "Greška, pokušajte ponovo!";
            else
                _this.statusMessage = error.error.details;
        });
    };
    ChangePasswordPageComponent.prototype.isFieldValid = function (name) {
        return !(this.changePasswordForm.controls[name].invalid && (this.changePasswordForm.controls[name].dirty || this.changePasswordForm.controls[name].touched));
    };
    ChangePasswordPageComponent.prototype.isPasswordValid = function () {
        return this.changePasswordForm.controls['newPassword'].value === this.changePasswordForm.controls['newPassword2'].value;
    };
    ChangePasswordPageComponent.prototype.closeForm = function () {
        this.router.navigate(['home/profile']);
    };
    ChangePasswordPageComponent = tslib_1.__decorate([
        Component({
            selector: 'app-change-password-page',
            templateUrl: './change-password-page.component.html',
            styleUrls: ['./change-password-page.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [FormBuilder, PatientRestService,
            Router, TokenService])
    ], ChangePasswordPageComponent);
    return ChangePasswordPageComponent;
}());
export { ChangePasswordPageComponent };
//# sourceMappingURL=change-password-page.component.js.map