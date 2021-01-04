export class ProfilePicture{
    private sellerLogoUrl:string;
    public deserialize(o: Object): ProfilePicture{
        if(!o)return;
        Object.assign(this, o);
        return this;
    }

    /**
     * Getter $sellerLogoUrl
     * @return {string}
     */
	public get $sellerLogoUrl(): string {
		return this.sellerLogoUrl;
	}

    /**
     * Setter $sellerLogoUrl
     * @param {string} value
     */
	public set $sellerLogoUrl(value: string) {
		this.sellerLogoUrl = value;
	}

}