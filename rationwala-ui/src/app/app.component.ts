import { Component } from '@angular/core';
import { UserProfile } from './_models';
import { AccountService } from './_services';
import { LoginResponse } from './_services/dto/login-response';


@Component({ selector: 'app', templateUrl: 'app.component.html' })
export class AppComponent {
    isLoggedIn = false;
    loginResponse: LoginResponse;
    cartCount:number = 0;
    constructor(private accountService: AccountService) {
        this.accountService.login.subscribe(x => {
            this.loginResponse = x;
            this.isLoggedIn = x != undefined && x != null;
        });
    }

    /**
     * Getter $cartCount
     * @return {number }
     */
	public get $cartCount(): number  {
		return this.cartCount;
	}

    /**
     * Setter $cartCount
     * @param {number } value
     */
	public set $cartCount(value: number ) {
		this.cartCount = value;
	}

    logout() {
        this.accountService.logout();
    }
}