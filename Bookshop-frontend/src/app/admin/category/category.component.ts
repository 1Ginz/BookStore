import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/service/category.service';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  success:string;
  categories:Category[]

  constructor(private CategoryService:CategoryService){}

  ngOnInit(): void {
      this.CategoryService.getCategories().subscribe(
        (data) => this.categories = data
      )
  }

  deleteCategory(id){
    this.CategoryService.deleteOne(id).subscribe(
      (data) => {
        this.categories = data;
        this.success = "Đã Xóa Thành Công"
      }
    )
  }

}
