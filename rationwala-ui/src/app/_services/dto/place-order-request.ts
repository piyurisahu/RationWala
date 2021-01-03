import { ItemInventory } from "src/app/_models/item-inventory";

export class PlaceOrderRequest{
    private buyerProfileId:number;
    private itemInventoryList:ItemInventory[];

    /**
     * Getter $buyerProfileId
     * @return {number}
     */
	public get $buyerProfileId(): number {
		return this.buyerProfileId;
	}

    /**
     * Getter $itemInventoryList
     * @return {ItemInventory[]}
     */
	public get $itemInventoryList(): ItemInventory[] {
		return this.itemInventoryList;
	}

    /**
     * Setter $buyerProfileId
     * @param {number} value
     */
	public set $buyerProfileId(value: number) {
		this.buyerProfileId = value;
	}

    /**
     * Setter $itemInventoryList
     * @param {ItemInventory[]} value
     */
	public set $itemInventoryList(value: ItemInventory[]) {
		this.itemInventoryList = value;
	}
    
}