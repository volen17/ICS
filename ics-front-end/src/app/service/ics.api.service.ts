import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Image} from "./image";
import {TagWithCount} from "./tag-with-count";

const SEPARATOR = '/';

@Injectable({
  providedIn: 'root',
})
export class IcsApiService {

  private readonly _url = 'http://localhost:8080';

  constructor(private readonly httpClient: HttpClient) {
  }

  public addImage(imageUrl: string): Observable<Image> {
    return this.httpClient.post<Image>(this._url + SEPARATOR + 'images?imageUrl=' + imageUrl, {})
  }

  public getImage(id: string): Observable<Image> {
    return this.httpClient.get<Image>(this._url + SEPARATOR + 'images' + SEPARATOR + id);
  }

  public getImages(order: string, pageSize: number, pageNumber: number): Observable<Image[]> {
    return this.httpClient.get<Image[]>(this._url + SEPARATOR + 'images?pageNumber=' + pageNumber + '&pageSize='+pageSize + '&order=' + order);
  }

  public getSuggestions(tagPrefix: string): Observable<TagWithCount[]> {
    return this.httpClient.get<TagWithCount[]>(this._url + SEPARATOR + 'tags?tagPrefix=' + tagPrefix);
  }

  public getImagesByTag(name: string): Observable<Image[]> {
    return this.httpClient.get<Image[]>(this._url + SEPARATOR + 'tags/' + name);
  }
}
