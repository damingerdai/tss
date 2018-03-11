import { Component, OnInit, Inject } from '@angular/core';
import { MatTableDataSource, MatDialog } from '@angular/material';

import { JobInfo } from '../commons/domain/jobinfo';
import { AddJobComponent } from './add.job/add.job.component';

const JOB_INFOS: JobInfo[] = [
  { jobName: 'job1', jobGroup: 'jobgroup1', cronExpression: '0 15 10 15 * ?', status: 1},
  { jobName: 'job2', jobGroup: 'jobgroup2', cronExpression: '0 15 10 15 * ?', status: 1}
];

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css'],
})
export class JobComponent implements OnInit {
  displayedColumns = ['jobName', 'jobGroup', 'cronExpression', 'status', 'action'];
  dataSource = new MatTableDataSource(JOB_INFOS);

  constructor(public dialog: MatDialog) {}

  addJob() {
    const dialogRef = this.dialog.open(AddJobComponent, {
      width: '250px',
      data: { name: 'arthur ming', animal: 'daming' }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
    });
  }

  ngOnInit() {
  }

}