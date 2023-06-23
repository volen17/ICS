import {Component, OnInit} from '@angular/core';
import {IcsApiService} from "../../../service/ics.api.service";
import {LoadingService} from "../../../service/loading.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-homepage-container',
  templateUrl: './homepage-container.component.html',
  styleUrls: ['./homepage-container.component.css']
})
export class HomepageContainerComponent implements OnInit {
  imageUrl: string | undefined;

  constructor(
    public icsApiService: IcsApiService,
    public loadingService: LoadingService,
    public router: Router,
  ) {
  }

  ngOnInit(): void {
  }

  addImage(event: Event) {
    event.preventDefault();

    if (!this.imageUrl) {
      return;
    }

    this.loadingService.start();
    this.icsApiService.addImage(this.imageUrl).subscribe(async image => {
      const id = image.id;
      await this.router.navigate([`images`, id]);
      this.loadingService.stop();
    });
  }

  public urlRegex = /(^|\s)((https?:\/\/)?[\w-]+(\.[\w-]+)+\.?(:\d+)?(\/\S*)?)/gi

  url = new FormControl('', [Validators.required, Validators.pattern(this.urlRegex)]);

  markTouched() {
    this.url.markAsTouched();
    this.url.updateValueAndValidity();
  }


}
