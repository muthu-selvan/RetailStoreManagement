import { Component, OnInit } from '@angular/core';
import { RetailStoreService } from '../services/retail-store.service';
import { Router } from '@angular/router';
import { ReturnResult } from '../classes/ReturnResult';
import { RetailStore } from '../classes/RetailStore';

@Component({
  selector: 'app-retail-store',
  templateUrl: './retail-store.component.html',
  styleUrls: ['./retail-store.component.css']
})
export class RetailStoreComponent implements OnInit {
  retailStoreCols: any[] = [];

  selectedStoreId!: number;
  retailStores!: RetailStore[];
  selectedRetailStore!: RetailStore;

  returnResult!: ReturnResult;
  showAlert: boolean = false;
  alertMsg!: string;

  constructor(
    private retailStoreService: RetailStoreService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAllRetailStoreInfo();
    this.retailStoreCols = this.retailStoreService.getRetailStoreHeaders();
  }

  add() {
    this.router.navigate(['add-retail-store']);
  }

  public deleteRetailStore() {
    this.retailStoreService.deleteRetailStore(this.selectedRetailStore.storeId).subscribe(
      response => {
        this.returnResult = response;
        if(this.returnResult.status === 'SUCCESS') {
          this.getAllRetailStoreInfo();
        } else {
            this.showAlert = true;
            this.alertMsg = this.returnResult.message;
        }
      }
    );
  }

  public getAllRetailStoreInfo() {
       this.retailStoreService.getAllRetailStoreInfo().subscribe(
      response => {
        this.retailStores = response;
      }
    );
  }

  public addRetailStore() {
    this.router.navigate(['add-retail-store']);
  }

  public editRetailStore() {
    this.router.navigate(['edit-retail-store',
     this.selectedRetailStore?.storeId
    ]);
  }

}
