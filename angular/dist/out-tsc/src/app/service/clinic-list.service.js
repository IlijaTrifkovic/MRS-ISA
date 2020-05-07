import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
var ClinicListService = /** @class */ (function () {
    function ClinicListService() {
        this.currentPage = 0;
        this.pageSize = 8;
        this.sortBy = "name";
        this.sortOrder = true;
    }
    ClinicListService.prototype.setDefaultPageValue = function () {
        this.currentPage = 0;
        this.pageSize = 8;
        this.sortBy = "name";
        this.sortOrder = true;
    };
    ClinicListService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], ClinicListService);
    return ClinicListService;
}());
export { ClinicListService };
//# sourceMappingURL=clinic-list.service.js.map