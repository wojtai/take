import {Component, OnInit} from '@angular/core';
import {MoviesService} from '../movies.service';
import {Movie, MovieCategory} from '../movie';
import {CartService} from '../cart.service';

@Component({
  selector: 'app-movie-cart',
  templateUrl: './movie-cart.component.html',
  styleUrls: ['./movie-cart.component.scss']
})
export class MovieCartComponent implements OnInit {

  public MovieCategory = MovieCategory;
  public readonly categories: string[] = Object.keys(MovieCategory);

  constructor(private moviesService: MoviesService, private cartService: CartService) { }

  public movies: Movie[] = [];
  public cart: Movie[] = [];

  public selectedMoviesCategory: MovieCategory = null;
  public selectedMoviesCurrency = 'PLN';
  public selectedCartCurrency = 'PLN';

  public getMovies(): void {
    this.moviesService.getMovies(this.selectedMoviesCategory, this.selectedMoviesCurrency).subscribe(
      data => {
        this.movies = data;
      },
      error => {
        console.error(error);
      }
    );
  }

  public getCart(): void {
    this.cartService.getCart(this.selectedCartCurrency).subscribe(
      data => {
        this.cart = data;
      },
      error => {
        console.error(error);
      }
    );
  }

  public filter(): void {
    console.log(this.selectedMoviesCategory, this.selectedMoviesCurrency);
    this.getMovies();
  }

  ngOnInit(): void {
    this.getMovies();
    this.getCart();
  }

  public addToCart(id: number): void {
    this.cartService.addToCart(id).subscribe(
      result => {
        this.getCart();
      },
      error => {
        console.error(error);
      }
    );
  }

  public removeFromCart(id: number) {
    this.cartService.removeFromCart(id).subscribe(
      result => {
        this.getCart();
      },
      error => {
        console.error(error);
      }
    );
  }

  public clearCart() {
    this.cartService.clearCart().subscribe(
      result => {
        this.getCart();
      },
      error => {
        console.error(error);
      }
    );
  }

  public cartValue(): number {
    return this.cart.map(x => x.price).reduce((a, b) => a + b, 0.0);
  }

}
