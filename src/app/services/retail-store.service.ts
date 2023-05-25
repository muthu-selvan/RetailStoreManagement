import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RetailStore } from '../classes/RetailStore';
import { API_URL } from 'src/app.component';
import { ReturnResult } from '../classes/ReturnResult';

@Injectable({
  providedIn: 'root'
})
export class RetailStoreService  implements OnInit {

  storeIds: string[] = [];
  filteredRetailStoreIds: string[] = [];

  retailStoreCols: any[] = [
    {field:'storeId', header:'Store ID'},
    {field:'sku', header:'SKU'},
    {field:'productName', header:'Product Name'},
    {field:'price', header:'Price'},
    {field:'date', header:'Date'}
  ];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {

  }

  public getAllRetailStoreInfo() {
    return this.http.get<RetailStore[]>(`${API_URL}/rms/retailStores`);
  }

  public deleteRetailStore(storeId: number) {
    return this.http.delete<ReturnResult>(`${API_URL}/rms/retailStore/${storeId}`);
  }

  public saveRetailStore(retailStore: RetailStore) {
    return this.http.post<ReturnResult>(`${API_URL}/rms/retailStore`,retailStore);
  }

  public getRetailStoreHeaders(): any[] {
    return this.retailStoreCols;
  }

  public getRetailStorebyStoreId(storeId: number) {
    return this.http.get<RetailStore>(`${API_URL}/rms/retailStore/${storeId}`);
  }

  public getFilteredRetailStoreIds(event: any): string[] {
    this.filteredRetailStoreIds = [];
    for(let i=0;i<this.filteredRetailStoreIds.length;i++) {
      let restId = this.filteredRetailStoreIds[i];
      if(restId.toLowerCase().indexOf(event.query.toLowerCase()) == 0) {
        this.filteredRetailStoreIds.push(restId);
      }
    }
    return this.filteredRetailStoreIds;
  }

}
