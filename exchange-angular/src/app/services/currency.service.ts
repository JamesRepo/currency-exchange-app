import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable()
export class CurrencyService {

  private readonly path = "/api/currency"

  constructor(private http: HttpClient) {}

  public getAllCurrencyCodes(): Observable<string []> {
    return this.http.get<string []>(`${environment.apiUrl}${this.path}/all`);
  }

}
