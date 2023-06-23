import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import {MatAutocomplete, MatAutocompleteModule, MatAutocompleteOrigin} from "@angular/material/autocomplete";
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";



@NgModule({
  declarations: [
    SearchbarComponent
  ],
  imports: [
    CommonModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatAutocompleteModule,
  ],
  exports: [
    SearchbarComponent
  ]
})
export class SearchbarModule { }
