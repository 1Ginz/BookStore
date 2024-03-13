import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, switchMap } from 'rxjs';
import { apiHost } from "./Api";
import { book } from "./book.service";
import { User } from './user.service';

export interface Checkout {
    id: number
    orderDate: string
    deliveryDate: any
    status: string
    total: number
    paymentMethod: string
    checkoutDetails: CheckoutDetail[]
    accept: boolean
    user: User
  }
  
  export interface CheckoutDetail {
    id: number
    quantity: number
    book: book
  }


@Injectable({
    providedIn: "root"
})
export class CheckoutService{

    constructor(private HttpClient:HttpClient){}

    Checkout():Observable<Checkout>{
        const url = `${apiHost}/check-out`;
        return this.HttpClient.get<Checkout>(url);
    }

    getTotalHistoryOrder():Observable<Checkout[]>{
        const url = `${apiHost}/user/order`;
        return this.HttpClient.get<Checkout[]>(url);
    }

    getHistoryOrder(id){
        const url = `${apiHost}/user/order/${id}`;
        return this.HttpClient.get<Checkout>(url);
    }

    CancelOrder(id):Observable<Checkout[]>{
        const url = `${apiHost}/user/cancel-order/${id}`;
        return this.HttpClient.delete(url).pipe(
            switchMap((data) =>{
                return this.getTotalHistoryOrder();
            })
        )
    }

    adminCancelOrder(id):Observable<Checkout[]>{
        const url = `${apiHost}/user/cancel-order/${id}`;
        return this.HttpClient.delete(url).pipe(
            switchMap((data) =>{
                return this.getAll();
            })
        )
    }

    adminAcceptOrder(id):Observable<Checkout[]>{
        const url = `${apiHost}/admin/accept-order/${id}`;
        return this.HttpClient.get(url).pipe(
            switchMap((data) =>{
                return this.getAll();
            })
        )
    }

    getAll():Observable<Checkout[]>{
        const url = `${apiHost}/admin/checkout`;
        return this.HttpClient.get<Checkout[]>(url);
    }

    getOrder(id):Observable<Checkout>{
        const url = `${apiHost}/admin/checkout/${id}`;
        return this.HttpClient.get<Checkout>(url);
    }




  }