export class GetOrderRequest{
    private userId:number;

    /**
     * Getter $userId
     * @return {number}
     */
	public get $userId(): number {
		return this.userId;
	}

    /**
     * Setter $userId
     * @param {number} value
     */
	public set $userId(value: number) {
		this.userId = value;
	}

}