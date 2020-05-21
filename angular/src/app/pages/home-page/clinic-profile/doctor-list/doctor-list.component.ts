import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Doctor } from 'src/app/model/model.doctor/Doctor';
import { Pageable } from 'src/app/model/Pageable';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {
  clinicId="";
  doctorList:Doctor[]= [];
  pageable:Pageable=new Pageable();


  constructor(private route:ActivatedRoute, private clinicService:ClinicRestService) { }

  ngOnInit() {
    this.getDoctorList();
  }
  
  getDoctorList(){
    this.clinicId=this.route.snapshot.paramMap.get('id');
    this.clinicService.getDoctorList(this.clinicId).subscribe(
      data=>{
        this.doctorList=data.content;
        this.pageable=data;
      }
    )
  }


}
