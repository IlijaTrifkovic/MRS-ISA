import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/service/token.service';
import { AuthService } from 'src/app/authentication/auth.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private tokenService:TokenService, private authService: AuthService) { }

  ngOnInit() {
  }

  signOut(){
    this.tokenService.signOut();
  }


  text="";
  m: Message= new Message();
  hello(){
    this.authService.helloTest().subscribe(
      da => {this.m=da;
      this.text=this.m.message});
  }

}

export class Message{
  message:string;
}
