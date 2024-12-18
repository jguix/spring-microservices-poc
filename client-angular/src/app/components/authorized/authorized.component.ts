// import { TokenService } from './../../services/token.service';
import { AuthService } from '../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ApiService } from 'src/app/services/api.service';
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
    private apiService: ApiService,
  ) { }

  ngOnInit(): void {
    // Subscribe to route query params and get "code" param
    this.activatedRoute.queryParams.subscribe( (params: Params) => {
      this.code = params.code;
      this.getToken().subscribe( () => {
        this.apiService.customers().subscribe(
          data => console.log('Customers: ' + JSON.stringify(data))
        );
        this.apiService.orders().subscribe(
          data => console.log('Orders: ' + JSON.stringify(data))
        );
      });
    });
  }

  getToken(): Observable<void> {
    return this.authService.getToken(this.code).pipe(map(
      (data: any) => {
        console.log('Tokens returned from authserver: ' + JSON.stringify(data));
        this.tokenService.setTokens(data.access_token, data.refresh_token);
      },
      (err: any) => {
        console.log(err);
      }
    ))
  }

}
