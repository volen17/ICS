import {Component, OnInit} from '@angular/core';
import {IcsApiService} from "../../../service/ics.api.service";
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';

import { debounceTime, tap, switchMap, finalize, distinctUntilChanged, filter } from 'rxjs/operators';
import {Router} from "@angular/router";


/**
 * @title Filter autocomplete
 */
@Component({
  selector: 'app-autocomplete',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {
  constructor(
    private icsApi: IcsApiService,
    private router: Router,
    private _formBuilder: FormBuilder
  ) {
  }

  myControl = new FormControl();
  filteredOptions: any;
  selectedTag: any = "";
  isLoading: boolean = false;
  tagSearchForm = this._formBuilder.group({
    name: ["myForm"]
  });


  onSelected() {
    this.selectedTag = this.selectedTag;
    this.onSubmit();
  }

  clearSelection() {
    this.selectedTag = "";
    this.filteredOptions = [''];
  }

  displayWith(value: any) {
    return value?.name;
  }

  ngOnInit() {
    this.myControl.valueChanges.pipe(
      filter(res => {
        return res !== null && res.length >= 0
      }),
      distinctUntilChanged(),
      debounceTime(1000),
      tap(() => {
        this.filteredOptions = [];
        this.isLoading = true;
      }),
      switchMap(value => this.icsApi.getSuggestions(value)
        .pipe(
          finalize(() => {
            this.isLoading = false
          }),
        )
      )
    )
      .subscribe(data => {
        this.filteredOptions = data.map(data => data.name);
      });
  }

  onSubmit() {
    this.router.navigate(['tags', this.selectedTag]);
  }
}
