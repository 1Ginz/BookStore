import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService, ListPageable, book } from 'src/app/service/book.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [],
})
export class HomeComponent implements OnInit {
  books: book[] = [];
  Pages: number[];
  currentPage: number;
  route: string;

  constructor (
    private bookService:BookService,
    private activedRoute: ActivatedRoute,
    private router: Router){
  }

  ngOnInit(): void {
        this.bookService.getAllBooksPageable().subscribe(
          (data:ListPageable) => {
            console.log("getAll");
            this.books = data.content;
            this.Pages = Array(data.totalPages).fill(0).map((n,i) => i+1);
            this.currentPage = data.pageable.pageNumber + 1;
          }
        )



      this.activedRoute.queryParams.subscribe(
        (queryParam) => {
          let type_sort:string = queryParam['type_sort'];
          const page:number = queryParam['page'];
          // const search:string = queryParam['search'];
          let param:string = '';
          if(page !== undefined){
            param+= `?pageNumber=${page-1}`
            if(type_sort !== undefined) param+=`&sort_by=price&type_sort=${type_sort}`
            this.bookService.getAllBooksPageable(param).subscribe(
              (data) => {this.books = data.content;
                this.currentPage = data.pageable.pageNumber + 1;
              }
            )
          }
          if(page === undefined && type_sort!== undefined){
            param+=`?sort_by=price&type_sort=${type_sort}`
            this.bookService.getAllBooksPageable(param).subscribe(
              (data) => {this.books = data.content;
              }
            )
          }
        }
      )

      this.route = this.router.url;
  };
  
  
}
