import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-add-job',
  templateUrl: './add.job.component.html',
  styleUrls: ['./add.job.component.css']
})
export class AddJobComponent implements OnInit {

  private dialogRef: MatDialogRef<AddJobComponent>;
  private data: any;

  constructor(dialogRef: MatDialogRef<AddJobComponent>, @Inject(MAT_DIALOG_DATA) data: any ) {
      this.dialogRef = dialogRef;
      this.data = data;
   }

   onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
