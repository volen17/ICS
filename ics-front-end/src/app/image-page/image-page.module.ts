import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImagePageContainerComponent } from './components/image-page-container/image-page-container.component';
import {MatTooltipModule} from "@angular/material/tooltip";



@NgModule({
  declarations: [
    ImagePageContainerComponent
  ],
  imports: [
    CommonModule,
    MatTooltipModule,
  ],
  exports: [
    ImagePageContainerComponent
  ]
})
export class ImagePageModule { }
