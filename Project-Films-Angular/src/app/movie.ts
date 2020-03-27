export enum MovieCategory {
  DRAMA = ('DRAMA'),
  COMEDY = ('COMEDY'),
  FAMILY = ('FAMILY'),
  ACTION = ('ACTION'),
  SCI_FI = ('SCI-FI'),
  CLASSIC = ('CLASSIC')
}

export class Movie {
  public id: number = undefined;
  public title: string = undefined;
  public category: MovieCategory = undefined;
  public year: string = undefined;
  public cast: string = undefined;
  public director: string = undefined;
  public story: string = undefined;
  public price: number = undefined;
}
