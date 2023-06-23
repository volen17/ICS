import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DarkModeToggleComponent } from './components/dark-mode-toggle/dark-mode-toggle.component';
import {MatIconModule} from "@angular/material/icon";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";



@NgModule({
  declarations: [
    DarkModeToggleComponent
  ],
  exports: [
    DarkModeToggleComponent
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatSlideToggleModule
  ]
})
export class DarkModeModule { }
