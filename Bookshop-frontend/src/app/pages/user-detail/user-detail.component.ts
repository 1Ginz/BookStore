import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { reloadCurrentRoute } from 'src/app/service/reload.service';
import { User, UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
    @ViewChild('userForm') userForm:NgForm;
    user:User;
    isEditing = false;
    isImageUploaded = false;

    constructor(private UserService:UserService,private Router:Router){}

  ngOnInit(): void {
      this.UserService.getUser().subscribe(
        (data) => this.user = data
      )
  }

  uploadUser(){
    const fileInput = document.getElementById('cover') as HTMLInputElement;
    const selectedFile = fileInput.files?.[0];
    this.user = this.userForm.value;
    console.log(this.user)
    const formData = new FormData();
    formData.append('avatarcover', selectedFile);
    formData.append('email', this.user.email);
    formData.append('name', this.user.name);
    formData.append('gender', this.user.gender);
    formData.append('phoneNumber', this.user.phoneNumber);
    this.UserService.upLoadUser(formData).subscribe(
      (data) => {this.user = data
        localStorage.setItem('username', data.name);
        localStorage.setItem('avt','http://localhost:2369' +data.avatar);
        reloadCurrentRoute(this.Router);
      },
      (error) => {console.log("error upload")}
    )
  }

  editSave() {
    this.isEditing = !this.isEditing;
    if (this.isEditing) {
      const fieldset = document.getElementsByTagName('fieldset')[0];
      fieldset.removeAttribute('disabled');
    } else {
      const fieldset = document.getElementsByTagName('fieldset')[0];
      fieldset.setAttribute('disabled',"");
      const x = document.getElementById('cover') as HTMLInputElement;
      x.type = 'hidden';
    }
  }

  preview(event: any) {
    const frame = document.getElementById('frame') as HTMLImageElement;
    frame.src = URL.createObjectURL(event.target.files[0]);
    this.isImageUploaded = true; // Reset the flag when a new image is selected
  }

}
