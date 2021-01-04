import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { PurchaseOrder } from '../_models/purchase-order';
import { AccountService, AlertService, ItemService, OrderService, UserService } from '../_services';
import { ChangeOrderStatusRequest } from '../_services/dto/change-order-status-request';
import { GetOrderRequest } from '../_services/dto/get-order-request';
import { GetOrderResponse } from '../_services/dto/get-order-response';

export class OrderRow {
    changeStatusForm: FormGroup;
    purchaseOrder: PurchaseOrder;
}
@Component({ templateUrl: 'store-orders.component.html' })
export class StoreOrdersComponent {
    displayedColumns: string[] = ['main', 'quantity', 'price', 'count'];
    getOrderResponse: GetOrderResponse = new GetOrderResponse();
    orders: OrderRow[];
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
        this.orders = new Array();
        this.orderService.getOrderBySeller(getOrderRequest).subscribe(
            data => {
                data.$purchaseOrderList.forEach(data => {
                    let row = new OrderRow();
                    row.changeStatusForm = this.formBuilder.group({
                        selectStore: new FormControl(data.$orderStatus)
                    });
                    row.purchaseOrder = data;
                    this.orders.push(row);
                });
                this.getOrderResponse = data;
            },
            error => {
                this.alertService.error(error);
            }
        );
    }
    radioChange(event, purchaseOrder: PurchaseOrder) {
        let req = new ChangeOrderStatusRequest();
        req.$purchaseOrder = purchaseOrder;
        req.$purchaseOrder.$orderStatus = event.value;
        this.orderService.changeOrderStatus(req).subscribe(
            data => {
                this.alertService.success('Status Changed Successfully.');
            },
            error => {
                this.alertService.error(error);
            }
        );
    }
}