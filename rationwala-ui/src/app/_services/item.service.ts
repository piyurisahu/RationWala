import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { GetSellerInventoryRequest } from './dto/get-seller-inventory-request';
import { GetSellerInventoryResponse } from './dto/get-seller-inventory-response';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private router: Router,
    private http: HttpClient) { }

  getAllSellers(sellerProfileId: number) {
    let getSellerInventoryRequest = new GetSellerInventoryRequest();
    getSellerInventoryRequest.$sellerProfileId = sellerProfileId;
    return this.http.post<GetSellerInventoryResponse>(`${environment.rationwalaApiUrl}/item/sellerInventory`, getSellerInventoryRequest)
      .pipe(map(getAllSellerResponse => {return new GetSellerInventoryResponse().deserialize(getAllSellerResponse).$itemInventoryList}));
  }
}
