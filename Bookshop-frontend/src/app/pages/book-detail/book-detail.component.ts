import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';
import { reloadCurrentRoute } from 'src/app/service/reload.service';
import { book } from '../../service/book.service';
import { Comment, CommentSerivce } from '../../service/comment.service';
import { OrderSerivce } from '../../service/order.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  @ViewChild('addtocart') addToCartForm: NgForm;
  @ViewChild('comment') commentForm: NgForm;

  orderSuccess:boolean;
  username = localStorage.getItem('username');
  book:book;
  listComment:Comment[] = [];

  constructor(private route:Router,
              private Router:ActivatedRoute,
              private bookSerivce:BookService,
              private CommentSerivce:CommentSerivce,
              private OrderSerivce:OrderSerivce){}

  ngOnInit(): void {

    const bookId = this.Router.snapshot.params['id'];

    this.bookSerivce.getById(bookId).subscribe(
      (data) => {
        this.book = data;
      }
    )
    this.CommentSerivce.getCommentByBook(bookId).subscribe(
      (data) => {
        this.listComment = data;
      }
    )
    

  }

  addToCart(){
    const quantity = this.addToCartForm.value.quantity;
    this.OrderSerivce.addOrder(this.book.id,quantity).subscribe(
      (data) => this.orderSuccess = true
    )
  }

  addComment(){
    const content = this.commentForm.value.content;
    this.CommentSerivce.addComment(this.book,content).subscribe(
      (data) => {reloadCurrentRoute(this.route)}
    )
  }

  deleteComment(id){
    this.CommentSerivce.deleteComment(id).subscribe(
      (data) => {reloadCurrentRoute(this.route)}
    )
  }


}
