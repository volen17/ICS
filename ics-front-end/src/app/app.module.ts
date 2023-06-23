import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DARK_MODE_OPTIONS } from 'angular-dark-mode';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarModule } from './navbar/navbar.module';
import {HomepageModule} from "./homepage/homepage.module";
import { HttpClientModule } from '@angular/common/http';
import {ImagePageModule} from "./image-page/image-page.module";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {GalleryPageModule} from "./gallery-page/gallery-page.module";
import { SearchbarComponent } from './searchbar/components/searchbar/searchbar.component';
import {InfiniteScrollModule} from "ngx-infinite-scroll";
import { TagImagesContainerComponent } from './gallery-page/components/tag-images-container/tag-images-container.component';
import {DarkModeModule} from "./dark-mode/dark-mode.module";
import {DarkModeToggleComponent} from "./dark-mode/components/dark-mode-toggle/dark-mode-toggle.component";
import {NavbarComponent} from "./navbar/components/navbar/navbar.component";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    NavbarModule,
    HomepageModule,
    HttpClientModule,
    ImagePageModule,
    MatProgressSpinnerModule,
    GalleryPageModule,
    InfiniteScrollModule,
    DarkModeModule
  ],
  providers: [
    SearchbarComponent,
    {
      provide: DARK_MODE_OPTIONS,
      useValue: {
        darkModeClass: 'my-dark-mode',
        lightModeClass: 'my-light-mode'
      }
    }
  ],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

