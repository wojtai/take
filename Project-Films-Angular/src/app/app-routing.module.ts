import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MovieCartComponent} from './movie-cart/movie-cart.component';
import {MovieViewComponent} from './movie-view/movie-view.component';


const routes: Routes = [
  {path: 'movie', component: MovieViewComponent},
  {path: '', component: MovieCartComponent},
  {path: '**', component: MovieCartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
