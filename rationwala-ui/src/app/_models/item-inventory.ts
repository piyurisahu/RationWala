import { Item } from "./item";

export class ItemInventory{
    private item:Item;
	private description:string;
	private price:number;
	private quantity:number;
    private unit:ItemUnitType;

    public deserialize(o: Object): ItemInventory{
        if(!o)return;
        Object.assign(this, o);
        this.$item = new Item().deserialize(this.$item);
        this.$unit = ItemUnitType[this.$unit as unknown as keyof typeof ItemUnitType]
        return this;
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
     * Getter $quantity
     * @return {number}
     */
	public get $quantity(): number {
		return this.quantity;
	}

    /**
     * Getter $unit
     * @return {ItemUnitType}
     */
	public get $unit(): ItemUnitType {
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
     * Setter $quantity
     * @param {number} value
     */
	public set $quantity(value: number) {
		this.quantity = value;
	}

    /**
     * Setter $unit
     * @param {ItemUnitType} value
     */
	public set $unit(value: ItemUnitType) {
		this.unit = value;
	}
    
}
export enum ItemUnitType{
    KILO_GRAM, LITER, COUNT
}