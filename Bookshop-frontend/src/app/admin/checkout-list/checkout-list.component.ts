import { Component, OnInit } from '@angular/core';
import { Checkout } from 'src/app/service/checkout.service';
import { CheckoutService } from '../../service/checkout.service';

@Component({
  selector: 'app-checkout-list',
  templateUrl: './checkout-list.component.html',
  styleUrls: ['./checkout-list.component.css']
})
export class CheckoutListComponent implements OnInit {
  success:string;
  orders:Checkout[];

  constructor(private CheckoutService:CheckoutService) {
    
  }

  ngOnInit(): void {
      this.CheckoutService.getAll().subscribe(
        (data) => this.orders = data
      )
  }

  accept(id){
    this.CheckoutService.adminAcceptOrder(id).subscribe(
      (data) => {
        this.orders = data;
        this.success = "Đã Chấp Nhận Đơn Thành Công"
      }
    )
  }

  cancel(id){
    this.CheckoutService.adminCancelOrder(id).subscribe(
      (data) => {
        this.orders = data;
        this.success = "Đã Hủy Đơn Thành Công"
      }
    )
  }

}
