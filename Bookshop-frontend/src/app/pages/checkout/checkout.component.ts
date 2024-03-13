import { Component, OnInit } from '@angular/core';
import { Checkout, CheckoutService } from '../../service/checkout.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  success:string;
  order:Checkout;

  constructor(private CheckoutService:CheckoutService,
              private ActivatedRoute:ActivatedRoute,
              private Router:Router){}

  ngOnInit(): void {

    const id = +this.ActivatedRoute.snapshot.params['id'];
    if(!id){
      this.CheckoutService.Checkout().subscribe(
        (data) => {
          this.success = "Đặt Hàng Thành Công";
          this.order = data;
        }
      )
    } else {
      this.CheckoutService.getHistoryOrder(id).subscribe(
        (data) => {
          this.order = data;
        }
      )
    }
      
  }

}
