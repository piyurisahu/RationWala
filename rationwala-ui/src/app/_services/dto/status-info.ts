
export class StatusInfo{
    private string:string;
    private messages: Message[];

    public deserialize(o: Object): StatusInfo{
        if(!o)return;
        Object.assign(this, o);
        return this;
    }

    /**
     * Getter $string
     * @return {string}
     */
	public get $string(): string {
		return this.string;
	}

    /**
     * Getter $messages
     * @return {Message[]}
     */
	public get $messages(): Message[] {
		return this.messages;
	}

    /**
     * Setter $string
     * @param {string} value
     */
	public set $string(value: string) {
		this.string = value;
	}

    /**
     * Setter $messages
     * @param {Message[]} value
     */
	public set $messages(value: Message[]) {
		this.messages = value;
	}
    
}

export class Message{
    private string:string;
	private identifier:string;
	private code:string;
    private message:string;

    public deserialize(o: Object): Message{
        if(!o)return;
        Object.assign(this, o);
        return this;
    }

    /**
     * Getter $string
     * @return {string}
     */
	public get $string(): string {
		return this.string;
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
     * Setter $string
     * @param {string} value
     */
	public set $string(value: string) {
		this.string = value;
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