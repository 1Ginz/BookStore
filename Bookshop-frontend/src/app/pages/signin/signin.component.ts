import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { host } from 'src/app/service/Api';
import { AccoutSerivce } from 'src/app/service/account.service';
import { User, UserService } from 'src/app/service/user.service';
import { Account } from '../../service/account.service';
import { map, switchMap } from 'rxjs';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
})
export class SigninComponent {

  account:Account;
  user:User;

  @ViewChild("f") loginForm:NgForm;

  constructor(private accountService:AccoutSerivce, private router: Router,private userService: UserService){

  }

  public onSubmit(){
    const username:string = this.loginForm.value.username;
    const pass:string = this.loginForm.value.password;

    this.accountService.Signin(username, pass).pipe(
      switchMap((data) => {
        this.account = data;
        localStorage.setItem("Authorization", 'Basic ' + btoa(`${username}:${pass}`));
        localStorage.setItem("Role", this.account.role);
        
        // Return the observable for the next step
        return this.userService.getUser();
      })
    ).subscribe(
      (user: User) => {
        this.user = user;
        localStorage.setItem("username", this.user.name);
        localStorage.setItem("avt", host + this.user.avatar);
        
        if (this.account.role === "ROLE_ADMIN") {
          this.router.navigate(["/admin"]);
        } else {
          this.router.navigate(["/"]);
        }
      },
      (error) => {
        // Handle errors if needed
        console.error('Error:', error);
      }
    );
  
  }


  //   this.userService.getUser().subscribe(
  //     (user:User) => {
  //       this.user = user;
  //       localStorage.setItem("username",this.user.name);
  //       localStorage.setItem("avt",host+this.user.avatar);
  //       if(this.account.role === "ROLE_ADMIN"){
  //         this.router.navigate(["/admin"])
  //       } else (this.router.navigate(["/"]))
  //     }
  //   )
  // }

}
