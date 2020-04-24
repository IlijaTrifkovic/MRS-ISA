import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PatientRestService } from 'src/app/service/patient-rest.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { AuthService } from 'src/app/authentication/auth.service';
import { TokenService } from 'src/app/service/token.service';


@Component({
  selector: 'app-change-password-page',
  templateUrl: './change-password-page.component.html',
  styleUrls: ['./change-password-page.component.css']
})
export class ChangePasswordPageComponent implements OnInit {
  changePasswordForm: FormGroup;
  statusMessage:string=''; 
  mesInfo:boolean=false;
  submit:boolean=false;

  constructor(private formBuilder: FormBuilder, private patientService: PatientRestService,
    public router: Router, private tokenService: TokenService) {
      this.changePasswordForm = formBuilder.group({
        oldPassword: ['',[Validators.required, Validators.minLength(8), Validators. maxLength(25)]],
        newPassword: ['',[Validators.required, Validators.minLength(8), Validators. maxLength(25)]],
        newPassword2: ['',[Validators.required, Validators.minLength(8), Validators. maxLength(25)]],
      });
  }

  ngOnInit() {
  }

  onSubmit() {
  
    if(!this.changePasswordForm.valid || !this.isPasswordValid()){
      this.statusMessage="Unesite validne podatke!"
      this.mesInfo=true;
      return;
    }
    
    this.submit=true;
    this.statusMessage="Slanje zahtjeva za registraciju..."
    this.mesInfo=true;
    const passwordInfo = this.changePasswordForm.value;
    
    this.patientService.changePassword(passwordInfo).subscribe(
      (data) => {
        this.tokenService.saveToken(data.token);
        this.submit = false;
        this.mesInfo=false;           
        this.router.navigate(['/home/profile']);
      },
      (error:HttpErrorResponse) => { 
        this.submit=false;
        if(!error.error.details)
          this.statusMessage="Greška, pokušajte ponovo!";
        else
          this.statusMessage=error.error.details;
      }
    );
  }

  isFieldValid(name:string){
    return !(this.changePasswordForm.controls[name].invalid && (this.changePasswordForm.controls[name].dirty || this.changePasswordForm.controls[name].touched));
  }

  isPasswordValid(){
    return this.changePasswordForm.controls['newPassword'].value===this.changePasswordForm.controls['newPassword2'].value;
  }

  closeForm(){
    this.router.navigate(['home/profile']);
  }
}
