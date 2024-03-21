import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit{
  accounts:any;
  constructor(private httpClient:HttpClient) {
  }
  ngOnInit(): void {
    this.httpClient.get("http://localhost:8888/ACCOUNT-SERVICE/accounts").subscribe({
      next:(value:any) =>{
        this.accounts=value;
      },
      error:(err:any) =>{
        this.accounts=err;
      }
    })
  }
}
