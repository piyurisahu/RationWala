import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AccountService, AlertService } from '../_services';
import { UserProfile } from '../_models/user-profile.model';
import { LoginCredential } from '../_services/dto/login-request';
import { ProfilePicture } from '../_models/profile-picture';

@Component({ templateUrl: 'register.seller.component.html' })
export class RegisterSellerComponent implements OnInit {
    form: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private accountService: AccountService,
        private alertService: AlertService
    ) { }

    ngOnInit() {
        this.form = this.formBuilder.group({
            firstName: new FormControl(''),
            lastName: new FormControl(''),
            email: new FormControl('', Validators.email),
            addl1: new FormControl(''),
            addl2: new FormControl(''),
            city: new FormControl(''),
            pincode: new FormControl('', Validators.pattern('^[0-9]{1,6}$')),
            state: new FormControl(''),
            phone: new FormControl('', Validators.pattern('^[0-9]{1,10}$')),
            password: new FormControl('', Validators.minLength(6)),
            sellerLogoUrl:new FormControl(''),
            sellerBusinessName:new FormControl(''),
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.form.controls; }

    onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.form.invalid) {
            return;
        }

        this.loading = true;
        let userProfile = new UserProfile();
        userProfile.$firstName = this.form.get('firstName').value;
        userProfile.$lastName = this.form.get('lastName').value;
        userProfile.$email = this.form.get('email').value;
        userProfile.$addressLine1 = this.form.get('addl1').value;
        userProfile.$addressLine2 = this.form.get('addl2').value;
        userProfile.$city = this.form.get('city').value;
        userProfile.$state = this.form.get('state').value;
        userProfile.$phoneNumber = this.form.get('phone').value;
        userProfile.$zipcode = this.form.get('pincode').value;
        userProfile.$sellerProfile = true;
        userProfile.$profilePicture = new ProfilePicture();
        userProfile.$profilePicture.$sellerLogoUrl = this.form.get('sellerLogoUrl').value;
        userProfile.$sellerBusinessName = this.form.get('sellerBusinessName').value;

        let loginCredential = new LoginCredential(this.form.get('email').value, this.form.get('password').value);

        this.accountService.register(userProfile, loginCredential)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Registration successful', { keepAfterRouteChange: true });
                    this.router.navigate(['../login'], { relativeTo: this.route });
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}