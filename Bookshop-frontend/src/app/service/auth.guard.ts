import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanActivateChild, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate,CanActivateChild {
  constructor(private router: Router) {}

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if (localStorage.getItem('Role') === 'ROLE_ADMIN') {
      return true; // Allow access to the route
    } else {
      // Redirect to the login page or any other route
      this.router.navigate(['/not-found']);
      return false; // Block access to the route
    }
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    // Check if the user has the "ROLE_ADMIN" role
    if (localStorage.getItem('Role') === 'ROLE_ADMIN') {
      return true; // Allow access to the route
    } else {
      // Redirect to the login page or any other route
      this.router.navigate(['/not-found']);
      return false; // Block access to the route
    }
  }
}