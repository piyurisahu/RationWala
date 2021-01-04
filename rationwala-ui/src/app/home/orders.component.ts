import { Component, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { AccountService, AlertService, ItemService, OrderService, UserService } from '../_services';
import { GetOrderRequest } from '../_services/dto/get-order-request';
import { GetOrderResponse } from '../_services/dto/get-order-response';

@Component({ templateUrl: 'orders.component.html' })
export class OrdersComponent {
    displayedColumns: string[] = ['main', 'quantity', 'price', 'count'];
    getOrderResponse: GetOrderResponse = new GetOrderResponse();
    name:string;
    constructor(
        private userService: UserService,
        private itemService: ItemService,
        private accountService: AccountService,
        private orderService: OrderService,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private alertService: AlertService,
        private appComponent: AppComponent) {
        let getOrderRequest = new GetOrderRequest();
        getOrderRequest.$userId = this.appComponent.loginResponse.$userProfile.$userProfileId;
        this.orderService.getOrderByBuyer(getOrderRequest).subscribe(
            data => {
                this.getOrderResponse = data;
                data.$purchaseOrderList.forEach(data=>{
                    data.$inventoryItemList.forEach(data=>{
                        this.name = data.$sellerProfile.$sellerBusinessName;
                    })
                })
            },
            error => {
                this.alertService.error(error);
            }
        );
    }
}