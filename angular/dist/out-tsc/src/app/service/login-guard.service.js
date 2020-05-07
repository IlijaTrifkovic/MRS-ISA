import * as tslib_1 from "tslib";
import { TokenService } from './token.service';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
var LoginGuardService = /** @class */ (function () {
    function LoginGuardService(tokenService, router) {
        this.tokenService = tokenService;
        this.router = router;
    }
    LoginGuardService.prototype.canActivate = function (route) {
        if (this.tokenService.checkIsLoggedIn()) {
            this.router.navigate(['']);
            return false;
        }
        return true;
    };
    LoginGuardService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [TokenService, Router])
    ], LoginGuardService);
    return LoginGuardService;
}());
export { LoginGuardService };
//# sourceMappingURL=login-guard.service.js.map