import { Component, OnInit } from '@angular/core';
import { PatientRestService } from 'src/app/service/patient-rest.service';
import { MedicalRecord } from 'src/app/model/MedicalRecord';

@Component({
  selector: 'app-medical-record',
  templateUrl: './medical-record.component.html',
  styleUrls: ['./medical-record.component.css']
})
export class MedicalRecordComponent implements OnInit {

  medicalRecord:MedicalRecord=new MedicalRecord();

  constructor(private patientService: PatientRestService) { }

  ngOnInit() {
    this.patientService.getMedicalRecord().subscribe(
      data => {       
        this.medicalRecord=data;  
      }
    );
  }

}
