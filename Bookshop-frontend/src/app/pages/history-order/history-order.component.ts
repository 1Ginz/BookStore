import { Component, OnInit } from '@angular/core';
import { Checkout } from 'src/app/service/checkout.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { CheckoutService } from '../../service/checkout.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-history-order',
  templateUrl: './history-order.component.html',
  styleUrls: ['./history-order.component.css']
})
export class HistoryOrderComponent implements OnInit {
  success:string;
  orders:Checkout[] = [];

  constructor(private Router:ActivatedRoute,
              private CheckoutService:CheckoutService){}
  
  
  ngOnInit(): void {
     this.Router.params.subscribe(
      (params:Params) => {
        const id = params['id'];
        if(id === undefined){
          this.CheckoutService.getTotalHistoryOrder().subscribe(
            (data) => this.orders = data
          )
        } else{
          this.CheckoutService.CancelOrder(id).subscribe(
            (data) => {this.orders = data;
                      this.success = "Huỷ Đơn Hàng Thành Công"
            }
          )
        }
      }
     )

  }
}
