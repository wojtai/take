import { Component, OnInit } from '@angular/core';
import {Movie} from '../movie';

@Component({
  selector: 'app-movie-view',
  templateUrl: './movie-view.component.html',
  styleUrls: ['./movie-view.component.scss']
})
export class MovieViewComponent implements OnInit {

  public movie: Movie = undefined;

  constructor() { }

  ngOnInit(): void {
    console.log(history.state.data);
    this.movie = history.state.data;
  }

}
