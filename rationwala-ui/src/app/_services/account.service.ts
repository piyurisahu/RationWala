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









    
    getAll() {
        return this.http.get<UserProfile[]>(`${environment.apiUrl}/users`);
    }

    getById(id: string) {
        return this.http.get<UserProfile>(`${environment.apiUrl}/users/${id}`);
    }

    update(id, params) {
        return this.http.put(`${environment.apiUrl}/users/${id}`, params)
            .pipe(map(x => {
                // update stored user if the logged in user updated their own record
                if (id == this.loginResponse.$userProfile.$userProfileId) {
                    // update local storage
                    const user = { ...this.loginResponse, ...params };
                    localStorage.setItem('loggedInUser', JSON.stringify(user));

                    // publish updated user to subscribers
                    this.userSubject.next(user);
                }
                return x;
            }));
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`)
            .pipe(map(x => {
                // auto logout if the logged in user deleted their own record
                if (id == this.loginResponse.$userProfile.$userProfileId) {
                    this.logout();
                }
                return x;
            }));
    }
}