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
  marss: mars= new mars();
  hello(){
    this.authService.helloTest().subscribe(
      da => {this.marss=da;
      this.text=this.marss.mars});
  }

}

export class mars{
  mars:string;
}
