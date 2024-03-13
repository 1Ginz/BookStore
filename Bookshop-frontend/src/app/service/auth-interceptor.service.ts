import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";

export class AuthInterceptorService implements HttpInterceptor{

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if(localStorage.getItem("Authorization")){
            const newRequest = req.clone({headers: req.headers.append('Authorization', localStorage.getItem('Authorization'),)})
            return next.handle(newRequest);
        }
        return next.handle(req);
    }
}