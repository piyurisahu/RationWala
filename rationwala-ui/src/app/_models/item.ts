export class Item{
    private itemId:number;
	private itemName:string;
	private itemBrand:string;
	private itemCategory:ItemCategoryType;
	private packageType:ItemPackageType;
	private itemType:string;

    public deserialize(o: Object): Item{
        if(!o)return;
        Object.assign(this, o);
        this.$itemCategory = ItemCategoryType[this.$itemCategory as unknown as keyof typeof ItemCategoryType]
        this.$packageType = ItemPackageType[this.$packageType as unknown as keyof typeof ItemPackageType]
        return this;
    }

    /**
     * Getter $itemId
     * @return {number}
     */
	public get $itemId(): number {
		return this.itemId;
	}

    /**
     * Getter $itemName
     * @return {string}
     */
	public get $itemName(): string {
		return this.itemName;
	}

    /**
     * Getter $itemBrand
     * @return {string}
     */
	public get $itemBrand(): string {
		return this.itemBrand;
	}

    /**
     * Getter $itemCategory
     * @return {ItemCategoryType}
     */
	public get $itemCategory(): ItemCategoryType {
		return this.itemCategory;
	}

    /**
     * Getter $packageType
     * @return {ItemPackageType}
     */
	public get $packageType(): ItemPackageType {
		return this.packageType;
	}

    /**
     * Getter $itemType
     * @return {string}
     */
	public get $itemType(): string {
		return this.itemType;
	}

    /**
     * Setter $itemId
     * @param {number} value
     */
	public set $itemId(value: number) {
		this.itemId = value;
	}

    /**
     * Setter $itemName
     * @param {string} value
     */
	public set $itemName(value: string) {
		this.itemName = value;
	}

    /**
     * Setter $itemBrand
     * @param {string} value
     */
	public set $itemBrand(value: string) {
		this.itemBrand = value;
	}

    /**
     * Setter $itemCategory
     * @param {ItemCategoryType} value
     */
	public set $itemCategory(value: ItemCategoryType) {
		this.itemCategory = value;
	}

    /**
     * Setter $packageType
     * @param {ItemPackageType} value
     */
	public set $packageType(value: ItemPackageType) {
		this.packageType = value;
	}

    /**
     * Setter $itemType
     * @param {string} value
     */
	public set $itemType(value: string) {
		this.itemType = value;
	}

}
export enum ItemCategoryType{
    ELECTRONIC, COSMETIC, EATABLE
}

export enum ItemPackageType{
    BRAND_PACKAGED, SELF_PACKAGED, LOOSE
}