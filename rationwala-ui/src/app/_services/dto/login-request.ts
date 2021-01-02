export class LoginRequest{
    private loginCredential:LoginCredential;

    /**
     * Getter $loginCredential
     * @return {LoginCredential}
     */
	public get $loginCredential(): LoginCredential {
		return this.loginCredential;
	}

    /**
     * Setter $loginCredential
     * @param {LoginCredential} value
     */
	public set $loginCredential(value: LoginCredential) {
		this.loginCredential = value;
	}

}
export class LoginCredential{
    private username:string;
    private password:string;
    
    constructor(username:string, password:string){
        this.username = username;
        this.password = password;
    }
    /**
     * Getter $username
     * @return {string}
     */
	public get $username(): string {
		return this.username;
	}

    /**
     * Getter $password
     * @return {string}
     */
	public get $password(): string {
		return this.password;
	}

    /**
     * Setter $username
     * @param {string} value
     */
	public set $username(value: string) {
		this.username = value;
	}

    /**
     * Setter $password
     * @param {string} value
     */
	public set $password(value: string) {
		this.password = value;
	}
}