import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: 'GetLetraDescoberta',
  pure: true
})
export class GetLetraDescoberta implements PipeTransform {

  transform(map: any, indice: number): string {
    return this.getLetraDescoberta(indice, map);
  }
  getLetraDescoberta(indice: number, map: any): string {
    console.info('---letra descoberta---')
    console.log(indice)
    if(map[indice]){
      console.info(map[indice])
      return map[indice];
    } else {
      return '_';
    }
  }

}
