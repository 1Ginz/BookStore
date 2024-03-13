import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService, book } from 'src/app/service/book.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  books: book[] = [];
  route: string;
  // search:string;
  constructor (
    private bookService:BookService,
    private activedRoute: ActivatedRoute,
    private router: Router){
  }

  ngOnInit(): void {
    this.activedRoute.queryParams.subscribe(
      (queryParam) => {
        let type_sort:string = queryParam['type_sort'];
        let search:string = queryParam['search'];
        if(type_sort!== undefined){
          let param:string =`?type_sort=${type_sort}`
          this.bookService.getBySearch(search,param).subscribe(
            (data) => this.books = data
          )
        } else {
          this.bookService.getBySearch(search).subscribe(
            (data) => this.books = data
          )
        }
      }
    )

    this.route = this.router.url;
    this.route = this.route.substring(0,7);
    console.log(this.route)
  }

}
