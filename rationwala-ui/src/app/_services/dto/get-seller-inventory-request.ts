export class GetSellerInventoryRequest{
    private sellerProfileId:number;

    /**
     * Getter $sellerProfileId
     * @return {number}
     */
	public get $sellerProfileId(): number {
		return this.sellerProfileId;
	}

    /**
     * Setter $sellerProfileId
     * @param {number} value
     */
	public set $sellerProfileId(value: number) {
		this.sellerProfileId = value;
	}

}