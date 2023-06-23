import { Component, OnInit } from '@angular/core';
import {Image} from "../../../service/image";
import {IcsApiService} from "../../../service/ics.api.service";
import {LoadingService} from "../../../service/loading.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {isPortrait} from "../../../common/functions";
import {Tag} from "../../../service/tag";

@Component({
  selector: 'app-tag-images-container',
  templateUrl: './tag-images-container.component.html',
  styleUrls: ['./tag-images-container.component.css']
})
export class TagImagesContainerComponent implements OnInit {
  images: Image[] | undefined;
  tagName: string = '';

  isPortrait = isPortrait;

  constructor(
    private icsApiService: IcsApiService,
    public loadingService: LoadingService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  name: string = '';

  ngOnInit(): void {
    this.loadingService.start();
    this.route.params.subscribe(params => {
      const name = params['name'];
      this.icsApiService.getImagesByTag(name).subscribe(data => {
        this.images = data;
        this.loadingService.stop();
      })
    })
  }



  async navigateToImage(id: number) {
    return this.router.navigate([`images`, id]);
  }

}

