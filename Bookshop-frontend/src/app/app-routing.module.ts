import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './admin/add-book/add-book.component';
import { AddCategoryComponent } from './admin/add-category/add-category.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { BookAdjustComponent } from './admin/book-adjust/book-adjust.component';
import { BookComponent } from './admin/book/book.component';
import { CategoryDetailComponent } from './admin/category-detail/category-detail.component';
import { CategoryComponent } from './admin/category/category.component';
import { CheckoutDetailComponent } from './admin/checkout-detail/checkout-detail.component';
import { CheckoutListComponent } from './admin/checkout-list/checkout-list.component';
import { BookDetailComponent } from './pages/book-detail/book-detail.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { HistoryOrderComponent } from './pages/history-order/history-order.component';
import { HomeComponent } from './pages/home/home.component';
import { LogOutComponent } from './pages/log-out/log-out.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { OrderComponent } from './pages/order/order.component';
import { SigninComponent } from './pages/signin/signin.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserDetailComponent } from './pages/user-detail/user-detail.component';
import { AuthGuard } from './service/auth.guard';
import { HomebycategoryComponent } from './pages/homebycategory/homebycategory.component';
import { SearchComponent } from './pages/search/search.component';

const routes: Routes = [
  // {path: "", redirectTo:"/home",pathMatch: 'full'},

  {path: "admin",canActivate: [AuthGuard], canActivateChild: [AuthGuard], component:AdminHomeComponent, children:[
    {path: "", component:BookComponent},
    {path: "orders", component:CheckoutListComponent},
    {path: "order/:id", component:CheckoutDetailComponent},
    {path: "books/add", component:AddBookComponent},
    {path: "books/:id", component:BookAdjustComponent},
    {path: "category/add", component:AddCategoryComponent},
    {path: "category/:id", component:CategoryDetailComponent},
    {path: "category", component:CategoryComponent},
    

  ]},
  {path: "check-out", component:CheckoutComponent},
  {path: "user/order/:id", component:CheckoutComponent},
  {path: "user/cancel-order/:id", component:HistoryOrderComponent},
  {path: "user/order", component:HistoryOrderComponent},
  {path: "", component:HomeComponent},

  {path: "order", component:OrderComponent},
  {path: "user", component:UserDetailComponent},
  {path: "search", component:SearchComponent},
  {path: "category", component:HomebycategoryComponent},
  {path: "books/:id", component:BookDetailComponent},
  {path: "sign-in", component:SigninComponent},
  {path: "sign-up", component:SignupComponent},
  {path: "not-found", component:NotFoundComponent},
  {path: "logout", component:LogOutComponent},
  {path: "**", redirectTo: "/not-found"},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
