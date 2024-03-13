import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Order, OrderSerivce } from '../../service/order.service';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  // @ViewChild('orderForm') orderForm:NgForm;

  order:Order;

  constructor(private OrderSerivce:OrderSerivce){}

  ngOnInit(): void {
      this.OrderSerivce.getUserOrder().subscribe(
          (data) => this.order = data
      )
  }

  updateOrder(action: string, OrderForm: NgForm) {
    if(action === 'update'){
      console.log("11111")
      this.OrderSerivce.updateOrder(OrderForm.value.id,OrderForm.value.quantity).subscribe(
        (data) => this.order = data
      )
    }
    if(action === 'delete'){
      this.OrderSerivce.deleteItem(OrderForm.value.id).subscribe(
        (data) => this.order = data
      )
    }
  }

}
