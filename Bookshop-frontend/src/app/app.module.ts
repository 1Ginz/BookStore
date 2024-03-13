import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { BookComponent } from './admin/book/book.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookDetailComponent } from './pages/book-detail/book-detail.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { FooterComponent } from './pages/footer/footer.component';
import { HeaderComponent } from './pages/header/header.component';
// import { HistoryCheckoutComponent } from './pages/history-checkout/history-checkout.component';
import { CategoryHomeComponent } from './pages/home/category-home/category-home.component';
import { HomeComponent } from './pages/home/home.component';
import { ListBookComponent } from './pages/home/list-book/list-book.component';
import { LogOutComponent } from './pages/log-out/log-out.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { OrderComponent } from './pages/order/order.component';
import { SigninComponent } from './pages/signin/signin.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserDetailComponent } from './pages/user-detail/user-detail.component';
import { AuthInterceptorService } from './service/auth-interceptor.service';
import { HistoryOrderComponent } from './pages/history-order/history-order.component';
import { AdminHeaderComponent } from './admin/admin-header/admin-header.component';
import { CategoryComponent } from './admin/category/category.component';
import { CategoryDetailComponent } from './admin/category-detail/category-detail.component';
import { BookAdjustComponent } from './admin/book-adjust/book-adjust.component';
import { AddCategoryComponent } from './admin/add-category/add-category.component';
import { AddBookComponent } from './admin/add-book/add-book.component';
import { CheckoutListComponent } from './admin/checkout-list/checkout-list.component';
import { CheckoutDetailComponent } from './admin/checkout-detail/checkout-detail.component';
import { HomebycategoryComponent } from './pages/homebycategory/homebycategory.component';
import { SearchComponent } from './pages/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    SigninComponent,
    SignupComponent,
    BookDetailComponent,
    UserDetailComponent,
    OrderComponent,
    CheckoutComponent,
    CategoryHomeComponent,
    BookComponent,
    AdminHomeComponent,
    NotFoundComponent,
    LogOutComponent,
    ListBookComponent,
    HistoryOrderComponent,
    AdminHeaderComponent,
    CategoryComponent,
    CategoryDetailComponent,
    BookAdjustComponent,
    AddCategoryComponent,
    AddBookComponent,
    CheckoutListComponent,
    CheckoutDetailComponent,
    HomebycategoryComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,

  ],
  providers: [{provide: HTTP_INTERCEPTORS,
              useClass: AuthInterceptorService,
              multi: true}],
  bootstrap: [AppComponent],
})
export class AppModule { }
