import { Component, OnInit } from '@angular/core';
import { Checkout } from 'src/app/service/checkout.service';
import { CheckoutService } from '../../service/checkout.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-checkout-detail',
  templateUrl: './checkout-detail.component.html',
  styleUrls: ['./checkout-detail.component.css']
})
export class CheckoutDetailComponent implements OnInit {
  order:Checkout;

  constructor(private CheckoutService:CheckoutService, private Router:ActivatedRoute){}

  ngOnInit(): void {
    const id = this.Router.snapshot.params['id']
    this.CheckoutService.getOrder(id).subscribe(
      (data) => {
        this.order = data;
      }
    )
  }
}
