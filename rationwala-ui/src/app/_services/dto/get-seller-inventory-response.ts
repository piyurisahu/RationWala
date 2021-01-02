import { ItemInventory } from "src/app/_models/item-inventory";
import { StatusInfo } from "./status-info";

export class GetSellerInventoryResponse{
    private itemInventoryList:ItemInventory[];
    private statusInfo:StatusInfo;

    public deserialize(o: Object): GetSellerInventoryResponse {
        if (!o) return;
        Object.assign(this, o);
        this.$statusInfo = new StatusInfo().deserialize(this.$statusInfo);
        if (this.$itemInventoryList) {
            let itemInventoryList: ItemInventory[] = new Array(this.$itemInventoryList.length);
            this.$itemInventoryList.forEach(x => { itemInventoryList.push(new ItemInventory().deserialize(x)); itemInventoryList.shift() });
            this.$itemInventoryList = itemInventoryList;
        }
        return this;
    }


    /**
     * Getter $itemInventoryList
     * @return {ItemInventory[]}
     */
	public get $itemInventoryList(): ItemInventory[] {
		return this.itemInventoryList;
	}

    /**
     * Getter $statusInfo
     * @return {StatusInfo}
     */
	public get $statusInfo(): StatusInfo {
		return this.statusInfo;
	}

    /**
     * Setter $itemInventoryList
     * @param {ItemInventory[]} value
     */
	public set $itemInventoryList(value: ItemInventory[]) {
		this.itemInventoryList = value;
	}

    /**
     * Setter $statusInfo
     * @param {StatusInfo} value
     */
	public set $statusInfo(value: StatusInfo) {
		this.statusInfo = value;
	}
    
    
}