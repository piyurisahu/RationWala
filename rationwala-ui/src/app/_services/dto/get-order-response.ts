import { PurchaseOrder } from "src/app/_models/purchase-order";
import { StatusInfo } from "./status-info";

export class GetOrderResponse{
    private purchaseOrderList:PurchaseOrder[];
    private statusInfo:StatusInfo;
    public deserialize(o: Object): GetOrderResponse {
        if (!o) return;
        Object.assign(this, o);
        this.$statusInfo = new StatusInfo().deserialize(this.$statusInfo);
        if (this.$purchaseOrderList) {
            let purchaseOrderList: PurchaseOrder[] = new Array(this.$purchaseOrderList.length);
            this.$purchaseOrderList.forEach(x => { purchaseOrderList.push(new PurchaseOrder().deserialize(x)); purchaseOrderList.shift() });
            this.$purchaseOrderList = purchaseOrderList;
        }
        return this;
    }

    /**
     * Getter $purchaseOrderList
     * @return {PurchaseOrder[]}
     */
	public get $purchaseOrderList(): PurchaseOrder[] {
		return this.purchaseOrderList;
	}

    /**
     * Getter $statusInfo
     * @return {StatusInfo}
     */
	public get $statusInfo(): StatusInfo {
		return this.statusInfo;
	}

    /**
     * Setter $purchaseOrderList
     * @param {PurchaseOrder[]} value
     */
	public set $purchaseOrderList(value: PurchaseOrder[]) {
		this.purchaseOrderList = value;
	}

    /**
     * Setter $statusInfo
     * @param {StatusInfo} value
     */
	public set $statusInfo(value: StatusInfo) {
		this.statusInfo = value;
	}

}