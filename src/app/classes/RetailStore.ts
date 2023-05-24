export class RetailStore {
    constructor(
      public storeId: number,
      public sku: string,
      public productName: string,
      public price: number,
      public date: Date
    ) {}
  }