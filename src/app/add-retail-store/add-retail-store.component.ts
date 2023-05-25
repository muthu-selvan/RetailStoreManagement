import { Component, OnInit } from '@angular/core';
import { RetailStoreService } from '../services/retail-store.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ReturnResult } from '../classes/ReturnResult';
import { RetailStore } from '../classes/RetailStore';
import { publicDecrypt } from 'crypto';

@Component({
  selector: 'app-add-retail-store',
  templateUrl: './add-retail-store.component.html',
  styleUrls: ['./add-retail-store.component.css']
})
export class AddRetailStoreComponent implements OnInit {

  storeId!: number;
  storeIds!: string[];
  sku!: string;
  productName!: string;
  price!: number;
  date!: Date;


  selectedRetailStore!: RetailStore;
  
  returnResult!: ReturnResult;
  showAlert: boolean = false;
  alertMsg!: string;

  
  constructor(
    private retailStoreService: RetailStoreService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    let storeIdObj = this.activatedRoute.snapshot.paramMap.get("storeId");
    if(storeIdObj !== null) {
      this.storeId = parseInt(storeIdObj);
      this.getRetailStoreById();
    }

    if(this.selectedRetailStore !== undefined && this.selectedRetailStore !== null) {
      this.productName = this.selectedRetailStore.productName;
      this.price = this.selectedRetailStore.price;
      this.date = this.selectedRetailStore.date;
    }
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

  public getRetailStoreById() {
    this.retailStoreService.getRetailStorebyStoreId(this.storeId).subscribe(
     response => {
     this.selectedRetailStore = response;
      }
    );
  }

 searchStoreId(event: any) {
  this.storeIds = this.retailStoreService.getFilteredRetailStoreIds(event);
  }
  
}
