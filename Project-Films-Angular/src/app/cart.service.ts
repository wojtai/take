import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Movie} from './movie';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private readonly url = '//localhost:8080/api/cart';

  constructor(private http: HttpClient) { }

  public addToCart(id: number): Observable<any> {
    return this.http.post(this.url + '/' + id, {});
  }

  public getCart(currency: string = 'PLN'): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.url + '?currencyType=' + currency);
  }

  public removeFromCart(id: number): Observable<any> {
    return this.http.delete(this.url + '/' + id);
  }

  public clearCart(): Observable<any> {
    return this.http.delete(this.url + '/clear');
  }
}
