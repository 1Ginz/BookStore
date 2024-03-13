import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookAdjustComponent } from './book-adjust.component';

describe('BookAdjustComponent', () => {
  let component: BookAdjustComponent;
  let fixture: ComponentFixture<BookAdjustComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookAdjustComponent]
    });
    fixture = TestBed.createComponent(BookAdjustComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
