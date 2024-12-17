import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  token_uri = environment.token_uri;

  constructor(private httpClient: HttpClient ) { }

  public getToken(code: string): Observable<any> {
    let body = new URLSearchParams();
    body.set('grant_type', environment.grant_type);
    body.set('client_id', environment.client_id);
    body.set('redirect_uri', environment.redirect_uri);
    body.set('scope', environment.scope);
    // body.set('response_type', environment.response_type);
    // body.set('response_mode', environment.response_mode);
    // body.set('code_challenge_method', environment.code_challenge_method);
    // body.set('code_challenge', environment.code_challenge);
    body.set('code_verifier', environment.code_verifier);
    body.set('code', code);
    const basic_auth = 'Basic ' + btoa('client:secret');
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Accept': '*/*',
      'Authorization': basic_auth,
    });
    const httpOptions = { headers: httpHeaders };

    return this.httpClient.post<any>(this.token_uri, body, httpOptions);
  }
}
