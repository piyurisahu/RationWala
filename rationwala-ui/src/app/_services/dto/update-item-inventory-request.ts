import { ItemInventory } from "src/app/_models/item-inventory";
import { UpdateItemInventoryResponse } from "./update-item-inventory-response";

export class UpdateItemInventoryRequest{
    private itemInventoryList:ItemInventory[];

    /**
     * Getter $itemInventoryList
     * @return {ItemInventory[]}
     */
	public get $itemInventoryList(): ItemInventory[] {
		return this.itemInventoryList;
	}

    /**
     * Setter $itemInventoryList
     * @param {ItemInventory[]} value
     */
	public set $itemInventoryList(value: ItemInventory[]) {
		this.itemInventoryList = value;
	}

}