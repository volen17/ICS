import {Tag} from "./tag";

export class Image {
  public url: string = '';
  public id: number = 0;
  public width: number = 0;
  public height: number = 0;
  public analysedAt: string = '';
  public analysedOn: Date = new Date();
  public tags: Tag[] = [];
}
