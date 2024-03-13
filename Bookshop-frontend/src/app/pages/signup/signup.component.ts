import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AccoutSerivce } from '../../service/account.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  @ViewChild('signupForm') signupForm:NgForm;

  success:boolean;

  constructor(private AccoutSerivce: AccoutSerivce) {
    
  }

  onSignup(){
    const username = this.signupForm.value.username;
    const password = this.signupForm.value.password;
    this.AccoutSerivce.Signup(username,password).subscribe({
      next: data => {this.success = true;
            console.log("signup")
      },
      error:error => {this.success = false}
    })
  }
}
