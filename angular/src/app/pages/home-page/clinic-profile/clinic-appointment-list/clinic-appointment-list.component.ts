import { Component, OnInit } from '@angular/core';
import { MedicalAppointment } from 'src/app/model/model.clinic/MedicalAppointment';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-clinic-appointment-list',
  templateUrl: './clinic-appointment-list.component.html',
  styleUrls: ['./clinic-appointment-list.component.css']
})
export class ClinicAppointmentListComponent implements OnInit {
  clinicId="";
  medicalAppointment:MedicalAppointment[]=[];
  medAppointment:MedicalAppointment= new MedicalAppointment;
  examinationID:number=-1;
  submitReservatinForm:boolean=false;
  statusMessage:string="";
  submitBtn:boolean=false;
  
  constructor(private clinicService:ClinicRestService, private route:ActivatedRoute) { }

  ngOnInit() {
    this.getAppointment();
  }

  schedule(id:number){
    this.examinationID=id;
    this.submitReservatinForm=true;
  }

  submit(){
    this.submitBtn=true;
    this.statusMessage="Slanje zahtjeva ...";
    this.clinicService.scheduleAppointment(this.examinationID).subscribe(
      data => {
        this.medAppointment=data.content;
        this.statusMessage="Zahtjev za rezervaciju je poslat. Provjerite Vaš mail."
        this.submitBtn=false;
        this.getAppointment();
      },
      (error:HttpErrorResponse) =>{
        if(!error.error.details)
           this.statusMessage="Greška, pokušajte ponovo.";
        else
           this.statusMessage="Zahtjev za rezervaciju je poslat. Provjerite Vaš mail."
        this.submitBtn=false;
      }
    );
  }

  closeDialog(){
    this.statusMessage="";
    this.examinationID=-1;
    this.submitReservatinForm=false;
  }

  getAppointment(){
    this.clinicId=this.route.snapshot.paramMap.get('id');
    this.clinicService.getAppointment(this.clinicId).subscribe(
      data => {
        this.medicalAppointment=data.content;
      }
    );
  }

}
