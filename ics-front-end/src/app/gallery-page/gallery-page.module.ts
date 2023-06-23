import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GalleryPageContainerComponent } from './components/gallery-page-container/gallery-page-container.component';
import {MatCardModule} from "@angular/material/card";
import {ImagePageModule} from "../image-page/image-page.module";
import { TagImagesContainerComponent } from './components/tag-images-container/tag-images-container.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';



@NgModule({
  declarations: [
    GalleryPageContainerComponent,
    TagImagesContainerComponent
  ],
  imports: [
    CommonModule,
    MatCardModule,
    ImagePageModule,
    InfiniteScrollModule,
  ]
})
export class GalleryPageModule { }
