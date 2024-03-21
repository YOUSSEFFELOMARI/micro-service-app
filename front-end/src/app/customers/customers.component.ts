import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [HttpClientModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers:any;
  constructor(private httpClient:HttpClient) {
  }
  ngOnInit(): void {
    this.httpClient.get("http://localhost:8888/CUSTOMER-SERVICE/customers").subscribe({
      next:(value:any) =>{
        this.customers=value;
      },
      error:(err:any) =>{
        this.customers=err;
      }
    })
  }
}
