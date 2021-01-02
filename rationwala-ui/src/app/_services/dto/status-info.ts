
export class StatusInfo{
    private status:Status;
    private messages: Message[];

    public deserialize(o: Object): StatusInfo{
        if(!o)return;
        Object.assign(this, o);
        this.$status = Status[this.$status as unknown as keyof typeof Status]
        return this;
    }

    /**
     * Getter $status
     * @return {Status}
     */
	public get $status(): Status {
		return this.status;
	}

    /**
     * Getter $messages
     * @return {Message[]}
     */
	public get $messages(): Message[] {
		return this.messages;
	}

    /**
     * Setter $status
     * @param {Status} value
     */
	public set $status(value: Status) {
		this.status = value;
	}

    /**
     * Setter $messages
     * @param {Message[]} value
     */
	public set $messages(value: Message[]) {
		this.messages = value;
	}
    
}
export enum Status{
    SUCCESS, ERROR, FAILUR
}

export class Message{
    private status:Status;
	private identifier:string;
	private code:string;
    private message:string;

    public deserialize(o: Object): Message{
        Object.assign(this, o);
        this.$status = Status[JSON.stringify(this.$status)];
        return this;
    }

    /**
     * Getter $status
     * @return {Status}
     */
	public get $status(): Status {
		return this.status;
	}

    /**
     * Getter $identifier
     * @return {string}
     */
	public get $identifier(): string {
		return this.identifier;
	}

    /**
     * Getter $code
     * @return {string}
     */
	public get $code(): string {
		return this.code;
	}

    /**
     * Getter $message
     * @return {string}
     */
	public get $message(): string {
		return this.message;
	}

    /**
     * Setter $status
     * @param {Status} value
     */
	public set $status(value: Status) {
		this.status = value;
	}

    /**
     * Setter $identifier
     * @param {string} value
     */
	public set $identifier(value: string) {
		this.identifier = value;
	}

    /**
     * Setter $code
     * @param {string} value
     */
	public set $code(value: string) {
		this.code = value;
	}

    /**
     * Setter $message
     * @param {string} value
     */
	public set $message(value: string) {
		this.message = value;
	}
    
}