import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { AuthService } from 'src/app/authentication/auth.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  email:String="";
  menuItemVisible:boolean;
  menuVisible:boolean;

  constructor(private tokenService: TokenService, private authService:AuthService, private router:Router) { 
    this.menuItemVisible=false;
    this.email= tokenService.getEmail();
    this.tokenService.emailEmitter.subscribe(email => this.email = email);
  }  

  signOut(){
    this.menuItemVisible=false;
    this.tokenService.signOut();
  }

  openProfile(){
    this.menuItemVisible=false;
    this.router.navigate(['/home/profile']);
  }

  visible(){
    this.menuItemVisible=!this.menuItemVisible;
  }

  ngOnInit() {
  }

}
