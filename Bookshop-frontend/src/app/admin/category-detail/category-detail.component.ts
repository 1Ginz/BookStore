import { Component, OnInit, ViewChild } from '@angular/core';
import { Category } from 'src/app/service/category.service';
import { CategoryService } from '../../service/category.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.css']
})
export class CategoryDetailComponent implements OnInit {

  @ViewChild('cateForm') cateForm:NgForm;
  message:string;
  isEditing:boolean = false;
  category:Category;

  constructor(private CategoryService:CategoryService,
              private Router:Router,
              private ActivatedRoute:ActivatedRoute) {
    
  }

  ngOnInit(): void {
      const id = this.ActivatedRoute.snapshot.params['id']
      this.CategoryService.getById(id).subscribe(
        (data) => this.category = data
      )
  }



  editSave() {
    this.isEditing = !this.isEditing;
    if (this.isEditing) {
      const fieldset = document.getElementsByTagName('fieldset')[0];
      fieldset.removeAttribute('disabled');
    }
  }

  delete(id){
    this.CategoryService.deleteOne(id).subscribe(
      (data) => {
        this.Router.navigateByUrl('/admin/category');
      }
    )
  }

  changeName(){
    this.category.name = this.cateForm.value.name;
    this.CategoryService.putCategory(this.category).subscribe(
      (data) => {this.category = data;
        this.message = "Đổi Tên Danh Mục Thành Công"
      }
    );
  }

}
