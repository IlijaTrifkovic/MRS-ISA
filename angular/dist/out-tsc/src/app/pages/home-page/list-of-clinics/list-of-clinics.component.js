import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Clinic } from 'src/app/model/Clinic';
import { ClinicPage } from 'src/app/model/ClinicPage';
import { Router } from '@angular/router';
import { ClinicListService } from 'src/app/service/clinic-list.service';
var ListOfClinicsComponent = /** @class */ (function () {
    function ListOfClinicsComponent(clinicService, router, clinicListService) {
        this.clinicService = clinicService;
        this.router = router;
        this.clinicListService = clinicListService;
        this.json = "";
        this.statusMessage = "";
        this.clinics = new Clinic();
        this.clinicPage = new ClinicPage();
        this.currentPage = 0;
        this.pageSize = 5;
        this.sortBy = "name";
        this.sortOrder = true; //true -> ASC 
    }
    ListOfClinicsComponent.prototype.getSortOrder = function () {
        return this.sortOrder ? "ASC" : "DESC";
    };
    ListOfClinicsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.getCurrentSortValue();
        this.clinicService.getClinic(this.currentPage, this.pageSize, this.sortBy, this.getSortOrder()).subscribe(function (data) {
            _this.clinicPage = data;
        });
        if ((this.clinicPage.totalPages - 1) < this.currentPage) {
            this.currentPage = this.clinicPage.totalPages;
            this.sortData();
        }
    };
    ListOfClinicsComponent.prototype.showClinicProfile = function (clinic) {
        this.router.navigate(['home/clinic-profile', clinic.id]);
    };
    ListOfClinicsComponent.prototype.sortDataBy = function (sortBy) {
        this.sortOrder = !this.sortOrder;
        this.sortBy = sortBy;
        this.sortData();
    };
    ListOfClinicsComponent.prototype.sortData = function () {
        var _this = this;
        this.saveCurrentValue();
        this.clinicService.getClinic(this.currentPage, this.pageSize, this.sortBy, this.getSortOrder()).subscribe(function (data) {
            _this.clinicPage = data;
        });
    };
    ListOfClinicsComponent.prototype.nextPage = function () {
        if (this.currentPage < this.clinicPage.totalPages - 1) {
            this.currentPage++;
            this.sortData();
        }
    };
    ListOfClinicsComponent.prototype.prevPage = function () {
        if (this.currentPage > 0) {
            this.currentPage--;
            this.sortData();
        }
    };
    ListOfClinicsComponent.prototype.saveCurrentValue = function () {
        this.clinicListService.currentPage = this.currentPage;
        this.clinicListService.sortBy = this.sortBy;
        this.clinicListService.pageSize = this.pageSize;
        this.clinicListService.sortOrder = this.sortOrder;
    };
    ListOfClinicsComponent.prototype.getCurrentSortValue = function () {
        this.currentPage = this.clinicListService.currentPage;
        this.sortBy = this.clinicListService.sortBy;
        this.pageSize = this.clinicListService.pageSize;
        this.sortOrder = this.clinicListService.sortOrder;
    };
    ListOfClinicsComponent = tslib_1.__decorate([
        Component({
            selector: 'app-list-of-clinics',
            templateUrl: './list-of-clinics.component.html',
            styleUrls: ['./list-of-clinics.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [ClinicRestService, Router,
            ClinicListService])
    ], ListOfClinicsComponent);
    return ListOfClinicsComponent;
}());
export { ListOfClinicsComponent };
//# sourceMappingURL=list-of-clinics.component.js.map