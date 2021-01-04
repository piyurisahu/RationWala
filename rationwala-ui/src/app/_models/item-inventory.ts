import { Item } from "./item";
import { UserProfile } from "./user-profile.model";

export class ItemInventory{
    private id:number;
    private sellerProfile:UserProfile;
    private item:Item;
	private description:string;
	private price:number;
    private countInStock:number;
    private quantity:number;
    private orderCount:number;
    private unit:string;

    public deserialize(o: Object): ItemInventory{
        if(!o)return;
        Object.assign(this, o);
        this.$item = new Item().deserialize(this.$item);
        this.$sellerProfile = new UserProfile().deserialize(this.$sellerProfile);
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
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}

    /**
     * Getter $item
     * @return {Item}
     */
	public get $item(): Item {
		return this.item;
	}

    /**
     * Getter $description
     * @return {string}
     */
	public get $description(): string {
		return this.description;
	}

    /**
     * Getter $price
     * @return {number}
     */
	public get $price(): number {
		return this.price;
	}

    /**
     * Getter $countInStock
     * @return {number}
     */
	public get $countInStock(): number {
		return this.countInStock;
	}

    /**
     * Getter $quantity
     * @return {number}
     */
	public get $quantity(): number {
		return this.quantity;
	}

    /**
     * Getter $orderCount
     * @return {number}
     */
	public get $orderCount(): number {
		return this.orderCount;
	}

    /**
     * Getter $unit
     * @return {string}
     */
	public get $unit(): string {
		return this.unit;
	}

    /**
     * Setter $item
     * @param {Item} value
     */
	public set $item(value: Item) {
		this.item = value;
	}

    /**
     * Setter $description
     * @param {string} value
     */
	public set $description(value: string) {
		this.description = value;
	}

    /**
     * Setter $price
     * @param {number} value
     */
	public set $price(value: number) {
		this.price = value;
	}

    /**
     * Setter $countInStock
     * @param {number} value
     */
	public set $countInStock(value: number) {
		this.countInStock = value;
	}

    /**
     * Setter $quantity
     * @param {number} value
     */
	public set $quantity(value: number) {
		this.quantity = value;
	}

    /**
     * Setter $orderCount
     * @param {number} value
     */
	public set $orderCount(value: number) {
		this.orderCount = value;
	}

    /**
     * Setter $unit
     * @param {string} value
     */
	public set $unit(value: string) {
		this.unit = value;
	} 
    
}