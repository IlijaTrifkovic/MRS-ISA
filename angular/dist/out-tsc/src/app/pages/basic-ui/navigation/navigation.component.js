import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { AuthService } from 'src/app/authentication/auth.service';
import { Router } from '@angular/router';
var NavigationComponent = /** @class */ (function () {
    function NavigationComponent(tokenService, authService, router) {
        var _this = this;
        this.tokenService = tokenService;
        this.authService = authService;
        this.router = router;
        this.email = "";
        this.menuItemVisible = false;
        this.email = tokenService.getEmail();
        this.tokenService.emailEmitter.subscribe(function (email) { return _this.email = email; });
    }
    NavigationComponent.prototype.signOut = function () {
        this.menuItemVisible = false;
        this.tokenService.signOut();
    };
    NavigationComponent.prototype.openProfile = function () {
        this.menuItemVisible = false;
        this.router.navigate(['/home/profile']);
    };
    NavigationComponent.prototype.visible = function () {
        this.menuItemVisible = !this.menuItemVisible;
    };
    NavigationComponent.prototype.ngOnInit = function () {
    };
    NavigationComponent = tslib_1.__decorate([
        Component({
            selector: 'app-navigation',
            templateUrl: './navigation.component.html',
            styleUrls: ['./navigation.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [TokenService, AuthService, Router])
    ], NavigationComponent);
    return NavigationComponent;
}());
export { NavigationComponent };
//# sourceMappingURL=navigation.component.js.map