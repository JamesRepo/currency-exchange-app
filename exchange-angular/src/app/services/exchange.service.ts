import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable()
export class ExchangeService {

  private readonly path = "/api/exchange"

  constructor(private http: HttpClient) {}

  public getConversion(from: string, to: string, amount: string): Observable<number> {
    return this.http.get<number>(`${environment.apiUrl}${this.path}/pair?base=${from}&target=${to}&amount=${amount}`);
  }

}
