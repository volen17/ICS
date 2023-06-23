enum Order {
  ASCENDING="asd",
  DESCENDING="desc",
}

export default class PaginationParams {

  // Order
  static getOrder() {
    return Order.ASCENDING;
  };

  // PageSize
  static getPageSize() {
    return 12;
  }

}
