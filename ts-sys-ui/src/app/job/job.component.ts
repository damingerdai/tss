import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';

import { JobInfo } from '../commons/domain/jobinfo';

const JOB_INFOS: JobInfo[] = [
  { jobName: 'job1', jobGroup: 'jobgroup1', cronExpression: '0 15 10 15 * ?', status: 1},
  { jobName: 'job2', jobGroup: 'jobgroup2', cronExpression: '0 15 10 15 * ?', status: 1}
];

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})

export class JobComponent implements OnInit {
  displayedColumns = ['jobName', 'jobGroup', 'cronExpression', 'status'];
  dataSource = new MatTableDataSource(JOB_INFOS);

  ngOnInit() {
  }

}