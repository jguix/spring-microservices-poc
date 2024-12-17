// import { TokenService } from './../../services/token.service';
import { AuthService } from '../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-authorized',
  templateUrl: './authorized.component.html',
  styleUrls: ['./authorized.component.css']
})
export class AuthorizedComponent implements OnInit {

  code = '';

  constructor(
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private tokenService: TokenService,
  ) { }

  ngOnInit(): void {
    // Subscribe to route query params and get "code" param
    this.activatedRoute.queryParams.subscribe( (params: Params) => {
      this.code = params.code;
      this.getToken();
    });
  }

  getToken(): void {
    this.authService.getToken(this.code).subscribe(
      (data: any) => {
        this.tokenService.setTokens(data.access_token, data.refresh_token);
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

}
