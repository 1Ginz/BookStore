import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/service/category.service';
import { CategoryService } from '../../../service/category.service';
@Component({
  selector: 'app-category-home',
  templateUrl: './category-home.component.html',
  styleUrls: ['./category-home.component.css']
})
export class CategoryHomeComponent implements OnInit {
  categories: Category[] = [];

  constructor(private categoryService:CategoryService,private router: ActivatedRoute,private route:Router){}

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe(
      (data) => {
        console.log("getCategory")
        this.categories = data;
      }
    )
  }

  findByCategory(id:number){
      this.route.navigate(["/cate",id])
  }
}
