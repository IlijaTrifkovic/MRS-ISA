import { Component, OnInit } from '@angular/core';
import { TokenService } from './../../service/token.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService} from './../../authentication/auth.service'; 
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  signupForm: FormGroup;
  statusMessage:string=''; 
  submit:boolean=false;
  mesInfo:boolean=false;
  
  constructor(private formBuilder: FormBuilder, private authHttpService: AuthService,
    private tokenService: TokenService ,public router: Router,) {
      this.signupForm = formBuilder.group({
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
        password: ['',[Validators.required, Validators.minLength(8),Validators.maxLength(25)]],
        password2: ['',[Validators.required, Validators.minLength(8),Validators.maxLength(25)]],
      });
  }
  ngOnInit() {
  }

  onSubmit() {
  
    if(!this.signupForm.valid || !this.isPasswordValid()){
      this.statusMessage="Unesite validne podatke!"
      this.mesInfo=true;
      return;
    }
    
    this.submit=true;
    this.statusMessage="Slanje zahtjeva za registraciju..."
    this.mesInfo=true;
    const loginInfo = this.signupForm.value;
    
    this.authHttpService.signup(loginInfo).subscribe(
      (data) => {
        this.submit = false;
        this.mesInfo=false;        
        alert("Zahtjev za registraciju je poslat.\nObavještenje će biti dostavljeno na email: "+
        this.signupForm.controls['email'].value+".");    
        this.router.navigate(['/login']);
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
    return !(this.signupForm.controls[name].invalid && (this.signupForm.controls[name].dirty || this.signupForm.controls[name].touched));
  }

  isPasswordValid(){
    return this.signupForm.controls['password'].value===this.signupForm.controls['password2'].value;
  }
}

