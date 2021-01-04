import { ItemInventory } from "./item-inventory";
import { UserProfile } from "./user-profile.model";

export class PurchaseOrder{
    private id:number;
    private buyerProfile:UserProfile;
    private sellerProfile:UserProfile;
	private totalPrice:number;
	private purchaseDate:string;
	private orderStatus:string;
    private inventoryItemList:ItemInventory[];
    
    public deserialize(o: Object): PurchaseOrder {
        if (!o) return;
        Object.assign(this, o);
        this.$buyerProfile = new UserProfile().deserialize(this.$buyerProfile);
        if (this.$inventoryItemList) {
            let inventoryItemList: ItemInventory[] = new Array(this.$inventoryItemList.length);
            this.$inventoryItemList.forEach(x => { inventoryItemList.push(new ItemInventory().deserialize(x)); inventoryItemList.shift() });
            this.$inventoryItemList = inventoryItemList;
            this.$sellerProfile = inventoryItemList[0].$sellerProfile;
        }
        return this;
    }

    /**
     * Getter $sellerProfile
     * @return {UserProfile}
     */
	public get $sellerProfile(): UserProfile {
		return this.sellerProfile;
	}

    /**
     * Setter $sellerProfile
     * @param {UserProfile} value
     */
	public set $sellerProfile(value: UserProfile) {
		this.sellerProfile = value;
	}

    /**
     * Getter $buyerProfile
     * @return {UserProfile}
     */
	public get $buyerProfile(): UserProfile {
		return this.buyerProfile;
	}

    /**
     * Setter $buyerProfile
     * @param {UserProfile} value
     */
	public set $buyerProfile(value: UserProfile) {
		this.buyerProfile = value;
	}
    

    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
	}

    /**
     * Getter $totalPrice
     * @return {number}
     */
	public get $totalPrice(): number {
		return this.totalPrice;
	}

    /**
     * Getter $purchaseDate
     * @return {string}
     */
	public get $purchaseDate(): string {
		return this.purchaseDate;
	}

    /**
     * Getter $orderStatus
     * @return {string}
     */
	public get $orderStatus(): string {
		return this.orderStatus;
	}

    /**
     * Getter $inventoryItemList
     * @return {ItemInventory[]}
     */
	public get $inventoryItemList(): ItemInventory[] {
		return this.inventoryItemList;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}

    /**
     * Setter $totalPrice
     * @param {number} value
     */
	public set $totalPrice(value: number) {
		this.totalPrice = value;
	}

    /**
     * Setter $purchaseDate
     * @param {string} value
     */
	public set $purchaseDate(value: string) {
		this.purchaseDate = value;
	}

    /**
     * Setter $orderStatus
     * @param {string} value
     */
	public set $orderStatus(value: string) {
		this.orderStatus = value;
	}

    /**
     * Setter $inventoryItemList
     * @param {ItemInventory[]} value
     */
	public set $inventoryItemList(value: ItemInventory[]) {
		this.inventoryItemList = value;
	}

}