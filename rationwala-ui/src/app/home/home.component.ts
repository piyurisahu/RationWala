import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserProfile } from '../_models';
import { ItemInventory } from '../_models/item-inventory';
import { AccountService, AlertService } from '../_services';
import { ItemService } from '../_services/item.service';
import { UserService } from '../_services/user.service';


@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {
    userProfile: UserProfile;
    sellerProfiles: UserProfile[];
    itemInventory: ItemInventory[];
    returnUrl: string;
    isLinear = true;
    selectStoreForm: FormGroup;
    secondFormGroup: FormGroup;
    selectedIndex: number = 0;
    constructor(
        private userService: UserService,
        private itemService: ItemService,
        private accountService: AccountService,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService) {
    }

    // convenience getter for easy access to form fields
    get ssf() { return this.selectStoreForm.controls; }

    ngOnInit() {
        this.selectStoreForm = this.formBuilder.group({
            selectStore: new FormControl()
        });
        this.secondFormGroup = this.formBuilder.group({
            secondCtrl: ['', Validators.required]
        });
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        this.userProfile = this.accountService.loginResponse.$userProfile;
        this.userService.getAllSellers(this.userProfile.$zipcode).subscribe(
            data => {
                this.sellerProfiles = data;
            },
            error => {
                this.alertService.error(error);
            });
    }

    selectionChange(event) {
        this.selectedIndex = event.selectedIndex;
        if(event.selectedIndex === 0) {
            this.userService.getAllSellers(this.userProfile.$zipcode).subscribe(
                data => {
                    this.sellerProfiles = data;
                },
                error => {
                    this.alertService.error(error);
                });
        }
        else if (event.selectedIndex === 1) {
            this.itemService.getAllSellers(this.ssf.selectStore.value).subscribe(
                data => {
                    this.itemInventory = data;
                },
                error => {
                    this.alertService.error(error);
                });
        }
    }
}