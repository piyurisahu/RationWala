import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { UserProfile } from '../_models';
import { LoginCredential, LoginRequest } from './dto/login-request';
import { LoginResponse } from './dto/login-response';
import { RegisterRequest } from './dto/register-request';
import { UpdateProfileRequest } from './dto/update-profile-request';


@Injectable({ providedIn: 'root' })
export class AccountService {
    private userSubject: BehaviorSubject<LoginResponse>;
    public login: Observable<LoginResponse>;

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.userSubject = new BehaviorSubject<LoginResponse>(new LoginResponse().deserialize(JSON.parse(localStorage.getItem('loggedInUser'))));
        this.login = this.userSubject.asObservable();
    }

    register(userProfile: UserProfile, loginCredential: LoginCredential) {
        let registerRequest = new RegisterRequest();
        registerRequest.$loginCredential = loginCredential;
        registerRequest.$userProfile = userProfile;
        return this.http.post(`${environment.rationwalaApiUrl}/account/register`, registerRequest);
    }

    updateProfile(userProfile: UserProfile) {
        let updateProfileRequest = new UpdateProfileRequest();
        updateProfileRequest.$userProfile = userProfile;
        return this.http.post(`${environment.rationwalaApiUrl}/account/profile/update`, updateProfileRequest);
    }

    public get loginResponse(): LoginResponse {
        return this.userSubject.value;
    }

    signIn(loginCredential: LoginCredential) {
        let loginRequest = new LoginRequest();
        loginRequest.$loginCredential = loginCredential;
        return this.http.post<LoginResponse>(`${environment.rationwalaApiUrl}/account/login`, loginRequest)
            .pipe(map(loginResponse => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('loggedInUser', JSON.stringify(loginResponse));
                this.userSubject.next(new LoginResponse().deserialize(loginResponse));
                return this.loginResponse;
            }));
    }

    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('loggedInUser');
        this.userSubject.next(null);
        this.router.navigate(['/account/login']);
    }
}