import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { PatientRestService } from 'src/app/service/patient-rest.service';
import { PatientProfile } from 'src/app/model/PatientProfile';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  profileUpdateForm: FormGroup;
  statusMessage:string=''; 
  edit:boolean=false;
  mesInfo:boolean=false;
  profile:PatientProfile=new PatientProfile();
  submit:boolean=false;

  constructor(private formBuilder: FormBuilder, private patientService: PatientRestService,
    public router: Router,) {
      this.profileUpdateForm = formBuilder.group({
        firstName: ['',[Validators.required, Validators.minLength(1),Validators.maxLength(20)]],
        lastName: ['',[Validators.required, Validators.minLength(1),Validators.maxLength(20)]],
        email: ['',[Validators.required, Validators.email]],
        phoneNumber: ['',[Validators.pattern("^[0-9]{0,20}$")]],
        jmbg: ['',[Validators.required, Validators.pattern("^[0-9]{13}$")]],
        lbo: ['',[Validators.required, Validators.pattern("^[0-9]{11}$")]],
        zk: ['',[Validators.required, Validators.pattern("^[0-9]{11}$")]],
        address: ['',[Validators.required, Validators.minLength(1), Validators. maxLength(30)]],
        city: ['',[Validators.required, Validators.minLength(1), Validators. maxLength(20)]],
        country: ['',[Validators.required, Validators.minLength(1), Validators. maxLength(20)]],
      });

      this.profileUpdateForm.controls.email.disable();
      this.profileUpdateForm.controls.lbo.disable();
      this.profileUpdateForm.controls.zk.disable();
      this.profileUpdateForm.controls.jmbg.disable();
  }


  ngOnInit() {
    this.disableForm();
    this.patientService.getProfile().subscribe(
      profile => {
        this.profile = profile;
        this.updateFormField(this.profile);
      }
    );
  }

  disableForm(){
    for (const field in this.profileUpdateForm.controls) { 
      this.profileUpdateForm.get(field).disable();
    }
  }
  enableForm(){
    for (const field in this.profileUpdateForm.controls) { 
      if(field!="jmbg" && field!="lbo" && field!="zk" && field!="email")
      this.profileUpdateForm.get(field).enable(); 
    }
  }

  editProfile(){
    this.edit=!this.edit;
    if(!this.edit){
      this.updateFormField(this.profile);
      this.disableForm();
      this.mesInfo=false;
    }else{
      this.enableForm();
    }
  }

  updateFormField(profile: PatientProfile){
    this.profileUpdateForm.controls.firstName.setValue(profile.firstName);
    this.profileUpdateForm.controls.lastName.setValue(profile.lastName)
    this.profileUpdateForm.controls.email.setValue(profile.email)
    this.profileUpdateForm.controls.phoneNumber.setValue(profile.phoneNumber);
    this.profileUpdateForm.controls.jmbg.setValue(profile.jmbg);
    this.profileUpdateForm.controls.lbo.setValue(profile.lbo);
    this.profileUpdateForm.controls.zk.setValue(profile.zk);
    this.profileUpdateForm.controls.address.setValue(profile.address);
    this.profileUpdateForm.controls.city.setValue(profile.city);
    this.profileUpdateForm.controls.country.setValue(profile.country);
  }

  onSubmit() {
  
    if(!this.profileUpdateForm.valid){
      this.statusMessage="Unesite validne podatke!"
      this.mesInfo=true;
      return;
    }

    this.submit=true;
    this.statusMessage="Ažuriranje profila...";
    this.mesInfo=true;
    const updateInfo = this.profileUpdateForm.value;

    this.patientService.updateProfile(updateInfo).subscribe(
      (data) => {       
        this.submit=false;
        this.profile=data;
        this.editProfile();     
      },
      (error:HttpErrorResponse) => { 
        if(!error.error.details)
          this.statusMessage="Greška, pokušajte ponovo!";
        else
          this.statusMessage=error.error.details;
        this.submit=false;
      }
    );
  }

  isFieldValid(name:string){
    return !(this.profileUpdateForm.controls[name].invalid && (this.profileUpdateForm.controls[name].dirty || this.profileUpdateForm.controls[name].touched));
  }

  changePassword(){
    this.router.navigate(['/home/changePassword']);
  }

}
