import { Component } from '@angular/core';
import { UserProfile } from './_models';
import { AccountService } from './_services';
import { LoginResponse } from './_services/dto/login-response';


@Component({ selector: 'app', templateUrl: 'app.component.html' })
export class AppComponent {
    isLoggedIn = false;
    loginResponse: LoginResponse;
    constructor(private accountService: AccountService) {
        this.accountService.login.subscribe(x => {
            this.loginResponse = x;
            this.isLoggedIn = x != undefined && x != null;

        });
    }
    logout() {
        this.accountService.logout();
    }
}