import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { BookService, book } from 'src/app/service/book.service';

@Component({
  selector: 'app-homebycategory',
  templateUrl: './homebycategory.component.html',
  styleUrls: ['./homebycategory.component.css']
})
export class HomebycategoryComponent implements OnInit {
  books: book[] = [];
  route: string;
  id:string;
  constructor (
    private bookService:BookService,
    private activedRoute: ActivatedRoute,
    private router: Router){
  }

  ngOnInit(): void {
    // this.activedRoute.params.subscribe(
    //     (param: Params) => {
    //       this.id = param['id'];
    //       if(this.id){
    //         console.log(this.id)
    //         this.bookService.getByCategory(this.id).subscribe(
    //           (data) => this.books = data
    //         )
    //       }
    //     }
    //   )
    //   this.activedRoute.queryParams.subscribe(
    //     (queryParam) => {
    //       let type_sort:string = queryParam['type_sort'];
    //       let param:string = '';
    //       if(type_sort){
    //         param+=`?sort_by=price&type_sort=${type_sort}`
    //         this.activedRoute.params.subscribe(
    //           (params: Params) => {
    //             // this.id = params['id'];
    //               this.bookService.getByCategory(params['id'],param).subscribe(
    //                 (data) => this.books = data
    //               )
    //           }
    //         )
    //       }
    //     }
    //   )

      this.activedRoute.queryParams.subscribe(
        (queryParam) => {
          let type_sort:string = queryParam['type_sort'];
          let categoryId:string = queryParam['id'];
          this.id = categoryId;
          if(type_sort!== undefined){
            let param:string =`?sort_by=price&type_sort=${type_sort}`
            this.bookService.getByCategory(this.id,param).subscribe(
              (data) => this.books = data
            )
          } else {
            this.bookService.getByCategory(this.id).subscribe(
              (data) => this.books = data
            )
          }
        }
      )

      this.route = this.router.url;
      this.route = this.route.substring(0,9);
      console.log(this.route)
  }

}
