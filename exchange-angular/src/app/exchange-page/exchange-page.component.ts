import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../services/currency.service';
import { ExchangeService } from '../services/exchange.service';

@Component({
  selector: 'app-exchange-page',
  templateUrl: './exchange-page.component.html',
  styleUrls: ['./exchange-page.component.scss']
})
export class ExchangePageComponent implements OnInit {

  public currencyCodes: string[] = [];

  public convertedAmount: string = '';

  constructor(
    private currencyService: CurrencyService,
    private exchangeService: ExchangeService
  ) { }

  ngOnInit(): void {
    this.getCurrencyCodes();
  }

  public convert(from: string, to: string, amount: string): void {
    this.exchangeService.getConversion(from, to, amount).subscribe(convAmount => this.convertedAmount = convAmount.toString());
  }

  private getCurrencyCodes(): void {
    this.currencyService.getAllCurrencyCodes().subscribe(cc => this.currencyCodes = cc);
  }

}
