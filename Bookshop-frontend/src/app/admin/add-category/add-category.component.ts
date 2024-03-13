import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Category } from 'src/app/service/category.service';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent {

  @ViewChild('categoryForm') cateForm:NgForm ;
  message:string;
  category:Category = {id: -1, name: ''};


  constructor(private CategoryService:CategoryService){
    
  }

  addCategory(){
    this.category.name = this.cateForm.value.name;
    console.log(this.cateForm.value.name)
    this.CategoryService.addCategory(this.category).subscribe(
      (data) => {this.category =  data;
                this.message = "Thêm Danh Mục Mới Thành Công"}
    )
  }

}
