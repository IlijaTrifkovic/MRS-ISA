import { Component, OnInit } from '@angular/core';
import { TokenService } from './../../service/token.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService} from './../../authentication/auth.service'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;
  statusMessage:string=''; 
  loginStat:boolean=false;
  mesStat:boolean=false;
  
  constructor(private formBuilder: FormBuilder, private authHttpService: AuthService,
    private tokenService: TokenService ,public router: Router,) {
      this.loginForm = formBuilder.group({
      email: ['',[Validators.required, Validators.email]],
      password: ['',[Validators.required, Validators.minLength(8),Validators.maxLength(25)]]
    });
  }
  ngOnInit() {
  }

  onLogin() {
    if(!this.loginForm.valid){
      this.statusMessage="Unesite validne podatke!"
      this.mesStat=true;
      return;
    }

    this.statusMessage="Prijavljivanje na sistem..."
    this.loginStat=true;
    this.mesStat=true;
    const loginInfo = this.loginForm.value;

    this.authHttpService.login(loginInfo).subscribe(
      (data) => {
        this.tokenService.saveToken(data.token);
        this.loginStat = false;
        this.mesStat=false;
        this.router.navigate(['']);
      },
      (error) => {
        console.log(error);
        this.loginStat = false;
        if(error.details)
          this.statusMessage = error.details;
        else
          this.statusMessage="Greška, pokušajte ponovo!";
      }
    );
  }
  
}
