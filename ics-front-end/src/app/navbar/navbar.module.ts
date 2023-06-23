import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MatButtonModule } from '@angular/material/button'
import {MatToolbarModule} from "@angular/material/toolbar";
import {RouterModule} from "@angular/router";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {ReactiveFormsModule} from "@angular/forms";
import {SearchbarComponent} from "../searchbar/components/searchbar/searchbar.component";
import {SearchbarModule} from "../searchbar/searchbar.module";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {AppModule} from "../app.module";
import {DarkModeModule} from "../dark-mode/dark-mode.module";



@NgModule({
  declarations: [

    NavbarComponent
  ],
    imports: [
        CommonModule,
        MatButtonModule,
        MatToolbarModule,
        RouterModule,
        MatFormFieldModule,
        MatAutocompleteModule,
        ReactiveFormsModule,
        SearchbarModule,
        MatInputModule,
        MatIconModule,
        MatSlideToggleModule,
        DarkModeModule
    ],
  exports: [
    NavbarComponent
  ]
})
export class NavbarModule { }
