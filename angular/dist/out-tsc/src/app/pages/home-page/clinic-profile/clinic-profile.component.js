import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { ClinicPage } from 'src/app/model/ClinicPage';
import { ActivatedRoute } from '@angular/router';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
var ClinicProfileComponent = /** @class */ (function () {
    function ClinicProfileComponent(route, clinicService) {
        this.route = route;
        this.clinicService = clinicService;
        this.clinicId = "";
        this.clinicProfile = new ClinicPage();
    }
    ClinicProfileComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.clinicId = this.route.snapshot.paramMap.get('id');
        this.clinicService.getClinicById(this.clinicId).subscribe(function (clinic) {
            _this.clinicProfile = clinic;
        });
    };
    ClinicProfileComponent = tslib_1.__decorate([
        Component({
            selector: 'app-clinic-profile',
            templateUrl: './clinic-profile.component.html',
            styleUrls: ['./clinic-profile.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [ActivatedRoute, ClinicRestService])
    ], ClinicProfileComponent);
    return ClinicProfileComponent;
}());
export { ClinicProfileComponent };
//# sourceMappingURL=clinic-profile.component.js.map