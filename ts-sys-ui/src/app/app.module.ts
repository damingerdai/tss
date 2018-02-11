import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatTableModule } from '@angular/material/table';

import { AppComponent } from './app.component';
import { DatasourceComponent } from './datasource/datasource.component';
import { JobComponent } from './job/job.component';

const appRoutes: Routes = [
  { path: 'datasource', component: DatasourceComponent }
];

@NgModule({
  exports: [
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatTableModule
  ],
  declarations: [DatasourceComponent, JobComponent]
})
export class AngularMasterailModule {}


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes
    ),
    BrowserModule,
    BrowserAnimationsModule,
    AngularMasterailModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
