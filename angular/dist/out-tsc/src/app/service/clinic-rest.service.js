import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
var ClinicRestService = /** @class */ (function () {
    function ClinicRestService(http) {
        this.http = http;
        this.url = environment.baseUrl;
        this.clinicUrl = '/clinic';
        this.medicalRecordUrl = "/medical-record";
    }
    ClinicRestService.prototype.getClinic = function (pageNumber, pageSize, sortBy, sortType) {
        return this.http.get(this.url + this.clinicUrl + "?page=" + pageNumber + "&size=" + pageSize +
            "&sort=" + sortBy + "," + sortType);
    };
    ClinicRestService.prototype.getClinicById = function (id) {
        return this.http.get(this.url + this.clinicUrl + "/" + id);
    };
    ClinicRestService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [HttpClient])
    ], ClinicRestService);
    return ClinicRestService;
}());
export { ClinicRestService };
//# sourceMappingURL=clinic-rest.service.js.map