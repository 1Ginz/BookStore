import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomebycategoryComponent } from './homebycategory.component';

describe('HomebycategoryComponent', () => {
  let component: HomebycategoryComponent;
  let fixture: ComponentFixture<HomebycategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomebycategoryComponent]
    });
    fixture = TestBed.createComponent(HomebycategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
