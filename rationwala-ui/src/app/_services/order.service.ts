import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { ChangeOrderStatusRequest } from './dto/change-order-status-request';
import { ChangeOrderStatusResponse } from './dto/change-order-status-response';
import { GetOrderRequest } from './dto/get-order-request';
import { GetOrderResponse } from './dto/get-order-response';
import { PlaceOrderRequest } from './dto/place-order-request';
import { PlaceOrderResponse } from './dto/place-order-response';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  placeOrder(placeOrderRequest: PlaceOrderRequest) {
    return this.http.post<PlaceOrderResponse>(`${environment.rationwalaApiUrl}/order/placeOrder`, placeOrderRequest)
      .pipe(map(placeOrderResponse => {return new PlaceOrderResponse().deserialize(placeOrderResponse)}));
  }

  getOrderByBuyer(getOrderRequest: GetOrderRequest) {
    return this.http.post<GetOrderResponse>(`${environment.rationwalaApiUrl}/order/buyer`, getOrderRequest)
      .pipe(map(getOrderResponse => {return new GetOrderResponse().deserialize(getOrderResponse)}));
  }

  getOrderBySeller(getOrderRequest: GetOrderRequest) {
    return this.http.post<GetOrderResponse>(`${environment.rationwalaApiUrl}/order/seller`, getOrderRequest)
      .pipe(map(getOrderResponse => {return new GetOrderResponse().deserialize(getOrderResponse)}));
  }

  changeOrderStatus(changeOrderStatus: ChangeOrderStatusRequest){
    return this.http.post<ChangeOrderStatusResponse>(`${environment.rationwalaApiUrl}/order/status/change`, changeOrderStatus)
    .pipe(map(getOrderResponse => {return new ChangeOrderStatusResponse().deserialize(changeOrderStatus)}));
  }
}
