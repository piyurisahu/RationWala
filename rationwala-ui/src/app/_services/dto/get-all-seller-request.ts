export class GetAllSellerRequest{
    private zipcode:string;
    
    /**
     * Getter $zipcode
     * @return {string}
     */
	public get $zipcode(): string {
		return this.zipcode;
	}

    /**
     * Setter $zipcode
     * @param {string} value
     */
	public set $zipcode(value: string) {
		this.zipcode = value;
	}

}