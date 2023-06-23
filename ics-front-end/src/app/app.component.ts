import { Component } from '@angular/core';
import {LoadingService} from "./service/loading.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Image Analyser';

  // TODO: LIGHT AND DARK THEME

  constructor(public loadingService: LoadingService) {}
}
