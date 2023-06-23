import { Component, OnInit } from '@angular/core';
import {IcsApiService} from "../../../service/ics.api.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Image} from "../../../service/image";
import {LoadingService} from "../../../service/loading.service";
import {Tag} from "../../../service/tag";
import {isPortrait} from "../../../common/functions";

@Component({
  selector: 'app-image-page-container',
  templateUrl: './image-page-container.component.html',
  styleUrls: ['./image-page-container.component.css']
})
export class ImagePageContainerComponent implements OnInit {
  image: Image | undefined;

  isPortrait = isPortrait;

  constructor(
    private icsApiService: IcsApiService,
    private route: ActivatedRoute,
    public loadingService: LoadingService,
    public router: Router
  ) { }

  ngOnInit(): void {
    this.loadingService.start();
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.icsApiService.getImage(id).subscribe(data => {
        this.image = data;
        this.image.tags = data.tags.sort((tag1: Tag, tag2: Tag) => {
          return tag1.confidence < tag2.confidence ? 1 : -1;
        })
        this.loadingService.stop();
      })
    })
  }

  onSubmit(tagName: string) {
    this.router.navigate(['tags', tagName]);
  }
}
