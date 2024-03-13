import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, switchMap } from 'rxjs';
import { apiHost } from './Api';

export interface Category {
    id: number;
    name: string;
}
@Injectable({
    providedIn: 'root',
})
export class CategoryService {

    constructor(private http: HttpClient) {}
  
    getCategories(): Observable<Category[]> {
      const url = `${apiHost}/category/`;
      return this.http.get<Category[]>(url);
    }

    getById(id): Observable<Category> {
      const url = `${apiHost}/category/${id}`;
      return this.http.get<Category>(url);
    }

    putCategory(category:Category){
      const url = `${apiHost}/category/${category.id}`;
      return this.http.put<Category>(url,category);
    }

    deleteOne(id){
      const url = `${apiHost}/category/${id}`;
      return this.http.delete(url).pipe(
        switchMap(
          (data) => {
            return this.getCategories()
          }
          )
      )
    }

    addCategory(category:Category){
      const url = `${apiHost}/category/add`;
      return this.http.post<Category>(url,category);
    }

  }