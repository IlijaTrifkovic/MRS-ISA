import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { PatientRestService } from 'src/app/service/patient-rest.service';
import { MedicalRecord } from 'src/app/model/MedicalRecord';
var MedicalRecordComponent = /** @class */ (function () {
    function MedicalRecordComponent(patientService) {
        this.patientService = patientService;
        this.medicalRecord = new MedicalRecord();
    }
    MedicalRecordComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.patientService.getMedicalRecord().subscribe(function (data) {
            _this.medicalRecord = data;
        });
    };
    MedicalRecordComponent = tslib_1.__decorate([
        Component({
            selector: 'app-medical-record',
            templateUrl: './medical-record.component.html',
            styleUrls: ['./medical-record.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [PatientRestService])
    ], MedicalRecordComponent);
    return MedicalRecordComponent;
}());
export { MedicalRecordComponent };
//# sourceMappingURL=medical-record.component.js.map