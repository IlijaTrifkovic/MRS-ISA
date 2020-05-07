var TokenPayload = /** @class */ (function () {
    function TokenPayload(sub, roles, audience, created, exp) {
        this.sub = sub;
        this.roles = roles;
        this.audience = audience;
        this.created = created;
        this.exp = exp;
        console.log("TUS:" + roles);
    }
    return TokenPayload;
}());
export { TokenPayload };
var Role = /** @class */ (function () {
    function Role(authority) {
        this.authority = authority;
    }
    return Role;
}());
export { Role };
//# sourceMappingURL=TokenPayload.js.map