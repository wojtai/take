import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Movie, MovieCategory} from './movie';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  private readonly url = '//localhost:8080/api/movie';

  constructor(private http: HttpClient) { }

  public getMovies(category: MovieCategory = null, currency: string = 'PLN'): Observable<Movie[]> {
    let targetUrl = this.url;
    targetUrl += '?currencyType=' + currency;
    if (category) {
      targetUrl += '&movieCategory=' + MovieCategory[category];
    }
    return this.http.get<Movie[]>(targetUrl);
  }
}
