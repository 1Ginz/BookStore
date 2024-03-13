import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { apiHost } from "./Api";
import { book } from "./book.service";
import { User } from "./user.service";

export interface OrderDetail {
    id: number
    quantity: number
    total: number
    book: book
}

export interface Order {
    id: number
    amountTotal: number
    user: User
    orderDetails: OrderDetail[]
}
@Injectable({
    providedIn: 'root'
})
export class OrderSerivce{
    
    constructor(private HttpClient:HttpClient){}

    getUserOrder():Observable<Order>{
        const url = apiHost+"/order/"
        return this.HttpClient.get<Order>(url);
    }

    updateOrder(id:string,quantity:number): Observable<Order>{
        const url = `${apiHost}/order/update?id=${id}&quantity=${quantity}`;
        return this.HttpClient.get<Order>(url);
    }

    deleteItem(id:string): Observable<Order>{
        const url = `${apiHost}/order/update?id=${id}`;
        return this.HttpClient.delete<Order>(url);
    }

    addOrder(id:number,quantity:number): Observable<Order>{
        const url = `${apiHost}/order/add?id=${id}&quantity=${quantity}`;
        return this.HttpClient.get<Order>(url);
    }


}