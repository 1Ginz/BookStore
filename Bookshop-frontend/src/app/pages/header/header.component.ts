import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  username:string
  avatar:string
  role:string
  @ViewChild("searchForm") searchForm:NgForm;
constructor(private router: ActivatedRoute, private Route:Router){}

  ngOnInit(): void {
    this.router.params.subscribe(
      (data) => {
        this.username = localStorage.getItem("username");
        this.avatar = localStorage.getItem("avt");
        this.role = localStorage.getItem("Role");
      }
    )
  }

  submitForm(){
    const search = this.searchForm.value.search;
    this.Route.navigate(['/search'],{queryParams: {'search': search} })
  }
}
