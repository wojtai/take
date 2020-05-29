import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { AboutComponentComponent } from './about-component/about-component.component';


const routes: Routes = [
  { path: 'students', component: StudentsComponent },
  { path: '', redirectTo: '/students', pathMatch: 'full' },
  { path: 'detail/:id', component: StudentDetailComponent },
  { path: 'about', component: AboutComponentComponent },
  { path: '**', redirectTo: '/students'} //wildcard
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
