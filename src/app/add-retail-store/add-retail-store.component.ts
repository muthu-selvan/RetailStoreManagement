import { Component, OnInit } from '@angular/core';
import { RetailStoreService } from '../services/retail-store.service';
import { Router } from '@angular/router';
import { ReturnResult } from '../classes/ReturnResult';
import { RetailStore } from '../classes/RetailStore';

@Component({
  selector: 'app-add-retail-store',
  templateUrl: './add-retail-store.component.html',
  styleUrls: ['./add-retail-store.component.css']
})
export class AddRetailStoreComponent implements OnInit {

  storeId!: number;
  sku!: string;
  productName!: string;
  price!: number;
  date!: Date;


  selectedRetailStore!: string;
  
  returnResult!: ReturnResult;
  showAlert: boolean = false;
  alertMsg!: string;

  
  constructor(
    private retailStoreService: RetailStoreService,
    private router: Router
  ) { }

  ngOnInit(): void {
   
  }

  save() {
    let retailStore = new RetailStore(this.storeId, this.sku, this.productName, this.price, this.date);
    this.retailStoreService.saveRetailStore(retailStore).subscribe(
      response => {
        this.returnResult = response;
        if(this.returnResult.status === 'SUCCESS') {
            this.router.navigate(['restuarants']);
        } else {
            this.showAlert = true;
            this.alertMsg = this.returnResult.message;
        }
      }
    );
  }

  cancel() {
    this.router.navigate(['retail-store']);
  }
  
}
