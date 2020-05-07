import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PatientRestService } from 'src/app/service/patient-rest.service';
import { PatientProfile } from 'src/app/model/PatientProfile';
var ProfilePageComponent = /** @class */ (function () {
    function ProfilePageComponent(formBuilder, patientService, router) {
        this.formBuilder = formBuilder;
        this.patientService = patientService;
        this.router = router;
        this.statusMessage = '';
        this.edit = false;
        this.mesInfo = false;
        this.profile = new PatientProfile();
        this.submit = false;
        this.profileUpdateForm = formBuilder.group({
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
        });
        this.profileUpdateForm.controls.email.disable();
        this.profileUpdateForm.controls.lbo.disable();
        this.profileUpdateForm.controls.zk.disable();
        this.profileUpdateForm.controls.jmbg.disable();
    }
    ProfilePageComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.disableForm();
        this.patientService.getProfile().subscribe(function (profile) {
            _this.profile = profile;
            _this.updateFormField(_this.profile);
        });
    };
    ProfilePageComponent.prototype.disableForm = function () {
        for (var field in this.profileUpdateForm.controls) {
            this.profileUpdateForm.get(field).disable();
        }
    };
    ProfilePageComponent.prototype.enableForm = function () {
        for (var field in this.profileUpdateForm.controls) {
            if (field != "jmbg" && field != "lbo" && field != "zk" && field != "email")
                this.profileUpdateForm.get(field).enable();
        }
    };
    ProfilePageComponent.prototype.editProfile = function () {
        this.edit = !this.edit;
        if (!this.edit) {
            this.updateFormField(this.profile);
            this.disableForm();
            this.mesInfo = false;
        }
        else {
            this.enableForm();
        }
    };
    ProfilePageComponent.prototype.updateFormField = function (profile) {
        this.profileUpdateForm.controls.firstName.setValue(profile.firstName);
        this.profileUpdateForm.controls.lastName.setValue(profile.lastName);
        this.profileUpdateForm.controls.email.setValue(profile.email);
        this.profileUpdateForm.controls.phoneNumber.setValue(profile.phoneNumber);
        this.profileUpdateForm.controls.jmbg.setValue(profile.jmbg);
        this.profileUpdateForm.controls.lbo.setValue(profile.lbo);
        this.profileUpdateForm.controls.zk.setValue(profile.zk);
        this.profileUpdateForm.controls.address.setValue(profile.address);
        this.profileUpdateForm.controls.city.setValue(profile.city);
        this.profileUpdateForm.controls.country.setValue(profile.country);
    };
    ProfilePageComponent.prototype.onSubmit = function () {
        var _this = this;
        if (!this.profileUpdateForm.valid) {
            this.statusMessage = "Unesite validne podatke!";
            this.mesInfo = true;
            return;
        }
        this.submit = true;
        this.statusMessage = "Ažuriranje profila...";
        this.mesInfo = true;
        var updateInfo = this.profileUpdateForm.value;
        this.patientService.updateProfile(updateInfo).subscribe(function (data) {
            _this.submit = false;
            _this.profile = data;
            _this.editProfile();
        }, function (error) {
            if (!error.error.details)
                _this.statusMessage = "Greška, pokušajte ponovo!";
            else
                _this.statusMessage = error.error.details;
            _this.submit = false;
        });
    };
    ProfilePageComponent.prototype.isFieldValid = function (name) {
        return !(this.profileUpdateForm.controls[name].invalid && (this.profileUpdateForm.controls[name].dirty || this.profileUpdateForm.controls[name].touched));
    };
    ProfilePageComponent.prototype.changePassword = function () {
        this.router.navigate(['/home/changePassword']);
    };
    ProfilePageComponent = tslib_1.__decorate([
        Component({
            selector: 'app-profile-page',
            templateUrl: './profile-page.component.html',
            styleUrls: ['./profile-page.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [FormBuilder, PatientRestService,
            Router])
    ], ProfilePageComponent);
    return ProfilePageComponent;
}());
export { ProfilePageComponent };
//# sourceMappingURL=profile-page.component.js.map