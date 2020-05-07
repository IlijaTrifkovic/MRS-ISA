import * as tslib_1 from "tslib";
import { environment } from 'src/environments/environment';
import { TokenService } from './../service/token.service';
import { Injectable } from '@angular/core';
var JwtInterceptor = /** @class */ (function () {
    function JwtInterceptor(tokenService) {
        this.tokenService = tokenService;
    }
    JwtInterceptor.prototype.intercept = function (request, next) {
        if (request.url.match(environment.baseUrl)) {
            var token = this.tokenService.getToken();
            if (token) {
                request = request.clone({
                    setHeaders: {
                        Authorization: "Bearer " + token
                    }
                });
            }
        }
        return next.handle(request);
    };
    JwtInterceptor = tslib_1.__decorate([
        Injectable(),
        tslib_1.__metadata("design:paramtypes", [TokenService])
    ], JwtInterceptor);
    return JwtInterceptor;
}());
export { JwtInterceptor };
//# sourceMappingURL=jwt-interceptor.js.map