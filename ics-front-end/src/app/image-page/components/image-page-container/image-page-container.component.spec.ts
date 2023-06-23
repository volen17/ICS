import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagePageContainerComponent } from './image-page-container.component';

describe('ImagePageContainerComponent', () => {
  let component: ImagePageContainerComponent;
  let fixture: ComponentFixture<ImagePageContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagePageContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagePageContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
