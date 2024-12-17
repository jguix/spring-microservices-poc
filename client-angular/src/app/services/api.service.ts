import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = environment.api_uri;

  constructor(private httpClient: HttpClient) { }

  public customers(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl + '/customers');
  }

  public orders(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl + '/orders');
  }
}
