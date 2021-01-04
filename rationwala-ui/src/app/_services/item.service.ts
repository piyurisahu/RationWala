import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { GetSellerInventoryRequest } from './dto/get-seller-inventory-request';
import { GetSellerInventoryResponse } from './dto/get-seller-inventory-response';
import { UpdateItemInventoryRequest } from './dto/update-item-inventory-request';
import { UpdateItemInventoryResponse } from './dto/update-item-inventory-response';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private http: HttpClient) { }

  getSellerInventory(sellerProfileId: number) {
    let getSellerInventoryRequest = new GetSellerInventoryRequest();
    getSellerInventoryRequest.$sellerProfileId = sellerProfileId;
    return this.http.post<GetSellerInventoryResponse>(`${environment.rationwalaApiUrl}/item/sellerInventory`, getSellerInventoryRequest)
      .pipe(map(getAllSellerResponse => {return new GetSellerInventoryResponse().deserialize(getAllSellerResponse).$itemInventoryList}));
  }
  updateInvetory(updateItemInventoryRequest: UpdateItemInventoryRequest) {
    return this.http.post<UpdateItemInventoryResponse>(`${environment.rationwalaApiUrl}/item/sellerInventory/update`, updateItemInventoryRequest)
      .pipe(map(updateItemInventoryResponse => {return new UpdateItemInventoryResponse().deserialize(updateItemInventoryResponse)}));
  }
}
