import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router, RouterLink} from "@angular/router";
import {SearchbarComponent} from "../../../searchbar/components/searchbar/searchbar.component";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isAnalyseButtonActive = false;
  isGalleryButtonActive = false;
  isSearchBarActive = false;

  constructor(
    private router: Router,
    public autocomplete: SearchbarComponent
  ) {
    router.events.subscribe(val => {
      if(val instanceof NavigationEnd) {
        if(val.url === '/') {
          this.isGalleryButtonActive = true;
          this.isAnalyseButtonActive = false;
          this.isSearchBarActive=false;
        }
        else if(val.url === '/images') {
          this.isAnalyseButtonActive = true;
          this.isGalleryButtonActive = false;
          this.isSearchBarActive=true;
        } else if(val.url.slice(0, 5) === '/tags') {
          this.isGalleryButtonActive = true;
          this.isAnalyseButtonActive = true;
          this.isSearchBarActive=true;
        }
        else {
          this.isGalleryButtonActive = true;
          this.isAnalyseButtonActive = true;
          this.isSearchBarActive=false;
        }
        console.log(this.isAnalyseButtonActive, this.isGalleryButtonActive)
      }
    })
  }

  async navigate(url: string) {
    return this.router.navigate([url]);
  }

  ngOnInit(): void {
  }
}
