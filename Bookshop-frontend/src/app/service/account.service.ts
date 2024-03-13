import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { apiHost } from './Api';

export interface Account {
  username: string;
  password: string;
  role: string;
}

@Injectable({
  providedIn: 'root',
})
export class AccoutSerivce {
  account: {
    username: string;
    password: string;
  };

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
    }),
  };

  constructor(private http: HttpClient) {}

  Signin(username: string, password: string): Observable<Account> {
    this.account = {
      username: username,
      password: password,
    };
    return this.http.post<Account>(`${apiHost}/account/signin`, this.account);
  }


    Signup(username: string, password:string): Observable<any>{
        this.account = {
        username : username,
        password : password,
        };
        return this.http.post<any>(`${apiHost}/account/signup`, this.account)
    }
}
