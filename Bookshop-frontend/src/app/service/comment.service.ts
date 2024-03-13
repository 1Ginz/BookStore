import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { apiHost } from "./Api";
import { book } from "./book.service";
import { User } from "./user.service";
export interface Comment {
    id: number
    content: string
    book: book
    user: User
}

@Injectable({
    providedIn: "root"
})
export class CommentSerivce{

    constructor(private httpclient:HttpClient){

    }

    getCommentByBook(id:string):Observable<Comment[]>{
        const url:string = apiHost + `/comment/book/${id}`;
        return this.httpclient.get<Comment[]>(url);
    }

    addComment(book:book, content:string):Observable<Comment>{
        const url:string = apiHost + '/comment/add?bookId=' + book.id;
        return this.httpclient.post<Comment>(url,{content: content,book: book},)
    }

    deleteComment(id:string): Observable<any>{
        const url:string = apiHost + '/comment/' + id;
        return this.httpclient.delete<any>(url);
    }
}