import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AccountService, AlertService } from '../_services';
import { UserProfile } from '../_models/user-profile.model';
import { LoginCredential } from '../_services/dto/login-request';

@Component({ templateUrl: 'edit-profile.component.html' })
export class EditProfileComponent implements OnInit {
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
            firstName: new FormControl(this.accountService.loginResponse.$userProfile.$firstName),
            lastName: new FormControl(this.accountService.loginResponse.$userProfile.$lastName),
            email: new FormControl(this.accountService.loginResponse.$userProfile.$email, Validators.email),
            addl1: new FormControl(this.accountService.loginResponse.$userProfile.$addressLine1),
            addl2: new FormControl(this.accountService.loginResponse.$userProfile.$addressLine2),
            city: new FormControl(this.accountService.loginResponse.$userProfile.$city),
            pincode: new FormControl(this.accountService.loginResponse.$userProfile.$zipcode, Validators.pattern('^[0-9]{1,6}$')),
            state: new FormControl(this.accountService.loginResponse.$userProfile.$state),
            phone: new FormControl(this.accountService.loginResponse.$userProfile.$phoneNumber, Validators.pattern('^[0-9]{1,10}$'))
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
        let userProfile = this.accountService.loginResponse.$userProfile;
        userProfile.$firstName = this.form.get('firstName').value;
        userProfile.$lastName = this.form.get('lastName').value;
        userProfile.$email = this.form.get('email').value;
        userProfile.$addressLine1 = this.form.get('addl1').value;
        userProfile.$addressLine2 = this.form.get('addl2').value;
        userProfile.$city = this.form.get('city').value;
        userProfile.$phoneNumber = this.form.get('phone').value;
        userProfile.$city = this.form.get('city').value;
        userProfile.$state = this.form.get('state').value;
        userProfile.$zipcode = this.form.get('pincode').value;
        userProfile.$state = this.form.get('state').value;

        this.accountService.updateProfile(userProfile)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Update successful', { keepAfterRouteChange: true });
                    this.router.navigate(['/'], { relativeTo: this.route });
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}