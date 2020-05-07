import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
var PatientRestService = /** @class */ (function () {
    function PatientRestService(http) {
        this.http = http;
        this.url = environment.baseUrl;
        this.patientProfileUrl = '/patient/profile';
        this.changePasswordUrl = '/changePassword';
        this.medicalRecordUrl = '/medical-record';
    }
    PatientRestService.prototype.getProfile = function () {
        return this.http.get(this.url + this.patientProfileUrl);
    };
    PatientRestService.prototype.updateProfile = function (loginInfo) {
        return this.http.post(this.url + this.patientProfileUrl, loginInfo, environment.httpOptions);
    };
    PatientRestService.prototype.changePassword = function (passwordInfo) {
        return this.http.post(this.url + this.changePasswordUrl, passwordInfo, environment.httpOptions);
    };
    PatientRestService.prototype.getMedicalRecord = function () {
        return this.http.get(this.url + this.medicalRecordUrl);
    };
    PatientRestService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], PatientRestService);
    return PatientRestService;
}());
export { PatientRestService };
//# sourceMappingURL=patient-rest.service.js.map