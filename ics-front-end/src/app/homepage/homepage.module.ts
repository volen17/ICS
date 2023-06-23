import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageContainerComponent } from './components/homepage-container/homepage-container.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    HomepageContainerComponent
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    HomepageContainerComponent
  ]
})
export class HomepageModule { }
