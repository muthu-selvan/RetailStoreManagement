import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddRetailStoreComponent } from './add-retail-store.component';

describe('AddRetailStoreComponent', () => {
  let component: AddRetailStoreComponent;
  let fixture: ComponentFixture<AddRetailStoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddRetailStoreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddRetailStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
