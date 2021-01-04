import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { GetAllSellerRequest } from './dto/get-all-seller-request';
import { GetAllSellerResponse } from './dto/get-all-seller-response';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAllSellers(zipcode: number) {
    let getAllSellerRequest = new GetAllSellerRequest();
    getAllSellerRequest.$zipcode = zipcode.toString();
    return this.http.post<GetAllSellerResponse>(`${environment.rationwalaApiUrl}/user/seller/all`, getAllSellerRequest)
      .pipe(map(getAllSellerResponse => {return new GetAllSellerResponse().deserialize(getAllSellerResponse).$sellerProfiles}));
  }
}
