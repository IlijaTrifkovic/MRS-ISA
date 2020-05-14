import { Component, OnInit } from '@angular/core';
import { MedicalAppointment} from 'src/app/model/model.clinic/MedicalAppointment';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Pageable } from 'src/app/model/Pageable';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {
  
  pageable:Pageable=new Pageable();
  medicalAppointment:MedicalAppointment[]=[];
  currentPage=0;
  pageSize=8;
  sortBy="date_time";
  sortOrder:boolean=true; //true -> ASC 
  message:string="";
  messageDialog:boolean=false;
  statusMessage:string="";
  appontmentId:number=0;

  dialogBtnSub:boolean=false;
  
  constructor(private clinicService:ClinicRestService) { }
 
  getSortOrder(){
    return this.sortOrder? "ASC" : "DESC";
  }

  ngOnInit() {
    this.sortData();
  }

  sortData(){
    this.clinicService.getPatientAppointment(this.currentPage,this.pageSize,this.sortBy,this.getSortOrder()).subscribe(
      data => {       
        this.medicalAppointment=data.content;
        this.pageable=data;
      }
    );
  }

  nextPage(){
    if(this.currentPage<this.pageable.totalPages-1){
      this.currentPage++;
      this.sortData();
    }
  }

  prevPage(){
    if(this.currentPage>0){
      this.currentPage--;
      this.sortData()
    }
  }

  sortDataBy(sortBy:string){
    this.sortOrder=!this.sortOrder;
    this.sortBy=sortBy;
    this.sortData();
  }

  cancelAppointment(){
    this.clinicService.cancelAppointment(this.appontmentId).subscribe(
      data=>{
        this.dialogBtnSub=false;
        this.message=data.message+"";
        this.statusMessage=this.message;
        this.sortData();
      }
    );
  }

  openDialog(medicalAppointment:MedicalAppointment){
    this.appontmentId=medicalAppointment.id;
    if(medicalAppointment.appointmentStatus=="SCHEDULED"){
      this.messageDialog=true;
    }
  }

  closeDialog(){
    this.statusMessage="";
    this.dialogBtnSub=false;
    this.messageDialog=false;
  }

  submit(){
    this.dialogBtnSub=true;
    this.statusMessage="otkazivanje...";
    this.cancelAppointment();
  }
}
