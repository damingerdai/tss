import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-datasource',
  templateUrl: './datasource.component.html',
  styleUrls: ['./datasource.component.css']
})
export class DatasourceComponent implements OnInit {

  apt: string = environment.api;
  constructor() { }

  ngOnInit() {
  }

}
