import { HttpClient, HttpHeaders } from "@angular/common/http"
import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { apiHost } from "./Api"
export interface User {
    id: number
    email: string
    name: string
    phoneNumber: string
    gender: string
    avatar: string
}

@Injectable({
    providedIn: "root"
})
export class UserService{
    private httpOptions = {
        headers: new HttpHeaders({
        'Content-Type': 'multipart/form-data;',
        })
        };

    constructor(private http:HttpClient){
    }

    getUser(): Observable<User>{
        return this.http.get<User>(`${apiHost}/user/info`)
    }

    upLoadUser(userForm: FormData): Observable<User>{
        const url = `${apiHost}/user/info`;
        return this.http.put<User>(url,userForm);
    }
}