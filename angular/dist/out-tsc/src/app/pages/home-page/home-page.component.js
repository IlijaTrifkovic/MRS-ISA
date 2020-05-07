import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { AuthService } from 'src/app/authentication/auth.service';
var HomePageComponent = /** @class */ (function () {
    function HomePageComponent(tokenService, authService) {
        this.tokenService = tokenService;
        this.authService = authService;
        this.text = "";
        this.m = new Message();
    }
    HomePageComponent.prototype.ngOnInit = function () {
    };
    HomePageComponent.prototype.hello = function () {
        var _this = this;
        this.authService.helloTest().subscribe(function (da) {
            _this.m = da;
            _this.text = _this.m.message;
        });
    };
    HomePageComponent = tslib_1.__decorate([
        Component({
            selector: 'app-home-page',
            templateUrl: './home-page.component.html',
            styleUrls: ['./home-page.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [TokenService, AuthService])
    ], HomePageComponent);
    return HomePageComponent;
}());
export { HomePageComponent };
var Message = /** @class */ (function () {
    function Message() {
    }
    return Message;
}());
export { Message };
//# sourceMappingURL=home-page.component.js.map