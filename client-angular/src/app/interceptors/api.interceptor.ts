import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenService } from '../services/token.service';

@Injectable()
export class ApiInterceptor implements HttpInterceptor {


  constructor(private tokenService: TokenService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    let intReq = request;
    const token = this.tokenService.getAccessToken();
    console.log('Including token in header: ' + token);
    if(token != null && request.url.includes('api')) {
      intReq = request.clone({headers: request.headers.set('Authorization', 'Bearer ' + token)});
    }
    return next.handle(intReq);
  }
}
