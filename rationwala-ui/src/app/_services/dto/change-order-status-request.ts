import { PurchaseOrder } from "src/app/_models/purchase-order";

export class ChangeOrderStatusRequest{
    private purchaseOrder:PurchaseOrder;

    /**
     * Getter $purchaseOrder
     * @return {PurchaseOrder}
     */
	public get $purchaseOrder(): PurchaseOrder {
		return this.purchaseOrder;
	}

    /**
     * Setter $purchaseOrder
     * @param {PurchaseOrder} value
     */
	public set $purchaseOrder(value: PurchaseOrder) {
		this.purchaseOrder = value;
	}

}