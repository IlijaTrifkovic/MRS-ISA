import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  email:String="";
  constructor(private tokenService: TokenService) { 
    this.email= tokenService.getEmail();
    this.tokenService.emailEmitter.subscribe(email => this.email = email);
  }  

  ngOnInit() {

  }

}
