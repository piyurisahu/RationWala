import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { UserProfile } from '../_models';
import { ItemInventory } from '../_models/item-inventory';
import { AccountService, AlertService, OrderService, ItemService, UserService } from '../_services';
import { PlaceOrderRequest } from '../_services/dto/place-order-request';

export class TableRow {
    main: string;
    desc: string;
    quantity: string;
    price: string;
    itemInventory: ItemInventory;
    count: number;
    constructor(itemInventory: ItemInventory) {
        this.itemInventory = itemInventory;
        this.main = itemInventory.$item.$itemBrand + ' ' + itemInventory.$item.$itemName;
        this.desc = itemInventory.$description;
        this.quantity = itemInventory.$quantity + ' ' + (itemInventory.$unit == 'KILO_GRAM' ? 'Kg.' : itemInventory.$unit == 'LITER' ? 'Ltr.' : itemInventory.$unit == 'GRAM' ? 'gm.' : itemInventory.$unit == 'ML' ? 'ml.' : '');
        this.price = itemInventory.$price.toString();
        this.count = 0;
    }
}

@Component({ templateUrl: 'home.component.html', styleUrls: ['home.component.css'] })
export class HomeComponent {
    selectItemdisplayedColumns: string[] = ['main', 'desc', 'quantity', 'price', 'action'];
    selectedItemdisplayedColumns: string[] = ['main', 'quantity', 'price', 'count'];
    userProfile: UserProfile;
    sellerProfiles: UserProfile[];
    itemInventoryList: ItemInventory[];
    returnUrl: string;
    isLinear = false;
    selectStoreForm: FormGroup;
    selectItemForm: FormGroup;
    selectedIndex: number = 0;
    selectedShop: string;
    selectItemdataSource: MatTableDataSource<TableRow>;
    cartDataSource: MatTableDataSource<TableRow>;
    totalCartPrice: number = 0;

    _value: number = 0;
    _step: number = 1;
    _min: number = 0;
    _max: number = Infinity;
    _wrap: boolean = false;
    color: string = 'default';
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
    }
    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;
    @ViewChild(MatTable) table: MatTable<any>;

    // convenience getter for easy access to form fields
    get ssf() { return this.selectStoreForm.controls; }
    get cartCount() { return this.appComponent.cartCount; }
    ngOnInit() {
        this.selectStoreForm = this.formBuilder.group({
            selectStore: new FormControl()
        });
        this.selectItemForm = this.formBuilder.group({
            secondCtrl: ['', Validators.required]
        });
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
        this.selectItemdataSource = new MatTableDataSource<TableRow>();
        this.cartDataSource = new MatTableDataSource<TableRow>();
        this.userProfile = this.accountService.loginResponse.$userProfile;
        this.userService.getAllSellers(this.userProfile.$zipcode).subscribe(
            data => {
                this.sellerProfiles = data;
            },
            error => {
                this.alertService.error(error);
            });
    }

    ngOnDestroy() {
        this.appComponent.cartCount = 0;
    }
    placeOrder() {
        let placeOrderRequest = new PlaceOrderRequest();
        placeOrderRequest.$buyerProfileId = this.userProfile.$userProfileId;
        let itemInventoryList = new Array(this.cartDataSource.data.length);
        this.cartDataSource.data.forEach(data => { 
            itemInventoryList.push(data.itemInventory);
            itemInventoryList.shift();
        });
        placeOrderRequest.$itemInventoryList = itemInventoryList;
        this.orderService.placeOrder(placeOrderRequest).subscribe(
            data => {
                this.router.navigate(['/orders']);
                this.alertService.success('Order Placed Successfully');
            },
            error => {
                this.alertService.error(error);
            });
    }
    selectionChange(event) {
        this.alertService.clear();
        if (event.selectedIndex === 0) {
            this.userService.getAllSellers(this.userProfile.$zipcode).subscribe(
                data => {
                    this.sellerProfiles = data;
                },
                error => {
                    this.alertService.error(error);
                });
        }
        else if (event.selectedIndex === 1 && this.selectedIndex === 0) {
            this.itemService.getAllSellers(this.ssf.selectStore.value).subscribe(
                data => {
                    this.itemInventoryList = data;
                    this.selectItemdataSource = new MatTableDataSource();
                    data.forEach(itemInventory => {
                        this.selectItemdataSource.data.push(new TableRow(itemInventory));
                    });
                    this.selectItemdataSource.paginator = this.paginator;
                    this.selectItemdataSource.sort = this.sort;
                    this.table.renderRows();
                },
                error => {
                    this.alertService.error(error);
                });
        }
        this.selectedIndex = event.selectedIndex;
    }
    radioChange(event) {
        this.sellerProfiles.filter(data => data.$userProfileId === event.value).map(data => this.selectedShop = data.$sellerBusinessName);
    }
    private parseNumber(num: any): number {
        return +num;
    }

    private parseBoolean(bool: any): boolean {
        return !!bool;
    }

    setColor(color: string): void {
        this.color = color;
    }

    getColor(): string {
        return this.color
    }

    incrementValue(step: number = 1, tableRow: TableRow): void {
        tableRow.count = tableRow.count + step;
        tableRow.itemInventory.$orderCount = tableRow.itemInventory.$orderCount + step;
        let inputValue = this._value + step;

        if (this._wrap) {
            inputValue = this.wrappedValue(inputValue);
        }

        this._value = inputValue;
        this.countCartItems();

    }

    private wrappedValue(inputValue): number {
        if (inputValue > this._max) {
            return this._min + inputValue - this._max;
        }

        if (inputValue < this._min) {

            if (this._max === Infinity) {
                return 0;
            }

            return this._max + inputValue;
        }

        return inputValue;
    }

    shouldDisableDecrement(tableRow: TableRow): boolean {
        return tableRow.count === 0;
    }

    shouldDisableIncrement(tableRow: TableRow): boolean {
        return tableRow.count === tableRow.itemInventory.$countInStock;
    }

    addToCart(tableRow: TableRow) {
        tableRow.count++;
        tableRow.itemInventory.$orderCount++;
        this.countCartItems();
    }
    private countCartItems() {
        this.appComponent.$cartCount = 0;
        this.totalCartPrice = 0;
        this.cartDataSource = new MatTableDataSource<TableRow>();
        this.selectItemdataSource.data.forEach(data => {
            if (data.count > 0) {
                this.totalCartPrice += (data.count * data.itemInventory.$price);
                this.cartDataSource.data.push(data);
            }
            this.appComponent.$cartCount += data.count;
        });

    }
}