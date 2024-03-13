import { Component, OnInit } from '@angular/core';
import { book } from 'src/app/service/book.service';
import { BookService } from '../../service/book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  success:string
  books:book[] = [];

  constructor(private BookService:BookService){

  }

  ngOnInit(): void {
      this.BookService.getAllBooks().subscribe(
        (data) => this.books = data
      )
  }

  deleteBook(id:number){
    this.BookService.delete(id).subscribe(
      (data) => {this.books = data;
                this.success = "Đã Xóa Thành Công"}
    )
  }

}
