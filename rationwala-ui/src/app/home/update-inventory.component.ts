import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import { Builder } from 'protractor';
import { ItemInventory } from '../_models/item-inventory';
import { AccountService, AlertService, ItemService } from '../_services';
import { UpdateItemInventoryRequest } from '../_services/dto/update-item-inventory-request';
import { TableRow } from './home.component';

@Component({
  templateUrl: './update-inventory.component.html'
})

export class UpdateInventoryComponent {
  selectItemdisplayedColumns: string[] = ['main', 'desc', 'quantity', 'price', 'action'];
  selectItemdataSource: MatTableDataSource<TableRow>;
  selectItemForm: FormGroup;
  _step: number = 1;
  color: string = 'default';
  constructor(private itemService: ItemService,
    private accountService: AccountService,
    private alertService: AlertService,
    private formBuilder: FormBuilder) {
    this.selectItemForm = this.formBuilder.group({
      price: ['', Validators.required]
    });
    this.itemService.getSellerInventory(this.accountService.loginResponse.$userProfile.$userProfileId).subscribe(
      data => {
        this.selectItemdataSource = new MatTableDataSource();
        data.forEach(itemInventory => {
          let row = new TableRow(itemInventory);
          row.count = itemInventory.$countInStock;
          this.selectItemdataSource.data.push(row);
        });
        this.selectItemdataSource.paginator = this.paginator;
        this.selectItemdataSource.sort = this.sort;
        this.table.renderRows();
      },
      error => {
        this.alertService.error(error);
      });
  }
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatTable) table: MatTable<any>;
  setColor(color: string): void {
    this.color = color;
  }

  getColor(): string {
    return this.color
  }

  incrementValue(step: number = 1, tableRow: TableRow): void {
    tableRow.count = tableRow.count + step;
    tableRow.itemInventory.$countInStock = tableRow.count;
  }

  shouldDisableDecrement(tableRow: TableRow): boolean {
    return tableRow.count === 0;
  }

  shouldDisableIncrement(tableRow: TableRow): boolean {
    return false;
  }
  updateInvetory() {
    let itemInventoryList = new Array();
    this.selectItemdataSource.data.forEach(data => {
      data.itemInventory.$description = data.desc;
      data.itemInventory.$countInStock = data.count;
      data.itemInventory.$price = data.price;
      itemInventoryList.push(data.itemInventory);
    });
    let req = new UpdateItemInventoryRequest();
    req.$itemInventoryList = itemInventoryList;
    this.itemService.updateInvetory(req).subscribe(
      data => {
        this.alertService.success('Inventory updated successfully.');
      },
      error => {
        this.alertService.error(error);
      });
  }
}