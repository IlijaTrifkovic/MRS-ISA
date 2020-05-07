import * as tslib_1 from "tslib";
import { TokenService } from './token.service';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
var RouteGuardService = /** @class */ (function () {
    function RouteGuardService(tokenService, router) {
        this.tokenService = tokenService;
        this.router = router;
    }
    RouteGuardService.prototype.canActivate = function (route) {
        if (!this.tokenService.checkIsLoggedIn()) {
            this.router.navigate(['/login']);
            return false;
        }
        return true;
    };
    RouteGuardService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [TokenService, Router])
    ], RouteGuardService);
    return RouteGuardService;
}());
export { RouteGuardService };
//# sourceMappingURL=route-guard.service.js.map