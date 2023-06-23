import {Image} from "../service/image";

export function isPortrait(image: Image | undefined): boolean {
  if(!image){
    return false;
  }
  return image.width<image.height
}
