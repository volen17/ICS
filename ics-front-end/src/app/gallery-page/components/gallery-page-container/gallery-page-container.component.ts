import {Component, OnInit} from '@angular/core';
import {LoadingService} from "../../../service/loading.service";
import {IcsApiService} from "../../../service/ics.api.service";
import {Image} from "../../../service/image";
import {Router} from "@angular/router";
import {isPortrait} from "../../../common/functions";
import PaginationParams from "../../../common/pagination-params"

@Component({
  selector: 'app-gallery-page-container',
  templateUrl: './gallery-page-container.component.html',
  styleUrls: ['./gallery-page-container.component.css']
})
export class GalleryPageContainerComponent implements OnInit {
  images: Image[] = [];
  pageNumber: number;
  endFlag = false;
  length: number;

  pageSize = PaginationParams.getPageSize();
  order = PaginationParams.getOrder();

  isPortrait = isPortrait;

  constructor(
    private icsApiService: IcsApiService,
    public loadingService: LoadingService,
    private router: Router,
  ) {
    this.pageNumber = 1;
    this.length = 0;
    this.appendItems();
  }

  ngOnInit(): void {
    // this.loadingService.start();
    //   this.icsApiService.getImages().subscribe(data => {
    //     this.images = data;
    //     this.loadingService.stop();
    //   })
  }

  async navigateToImage(id: number) {
    return this.router.navigate([`images`, id]);
  }

  onScrollDown() {
    console.log("down");
    this.appendItems();
  }

  appendItems() {
    if (this.endFlag) {
      console.log('that\'s all');
    } else {
      this.loadingService.start();
      this.icsApiService.getImages(this.order, this.pageSize, this.pageNumber).subscribe(data => {
        data.forEach(x => this.images?.push(x));
        if(this.length==this.images.length){
          this.endFlag=true;
        }
        this.pageNumber += 1;
        this.length=this.images.length;
        this.loadingService.stop();
      });
    }
  }
}
