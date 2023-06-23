import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagImagesContainerComponent } from './tag-images-container.component';

describe('TagImagesContainerComponent', () => {
  let component: TagImagesContainerComponent;
  let fixture: ComponentFixture<TagImagesContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TagImagesContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TagImagesContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
