import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomepageContainerComponent} from "./homepage/components/homepage-container/homepage-container.component";
import {ImagePageContainerComponent} from "./image-page/components/image-page-container/image-page-container.component";
import {GalleryPageContainerComponent} from "./gallery-page/components/gallery-page-container/gallery-page-container.component";
import {TagImagesContainerComponent} from "./gallery-page/components/tag-images-container/tag-images-container.component";

const routes: Routes = [
  {
    path: 'images',
    children: [
      {
        path: ':id',
        component: ImagePageContainerComponent
      },
      {
        path: '',
        component: GalleryPageContainerComponent
      }
    ]
  },
  { path: 'tags', children: [
    {
      path: ':name',
      component: TagImagesContainerComponent,
      data: {name: ':name'}
    }]},
  { path: '', component: HomepageContainerComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
