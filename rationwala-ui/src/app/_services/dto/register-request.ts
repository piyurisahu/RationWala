import { UserProfile } from "src/app/_models";
import { LoginCredential } from "./login-request";

export class RegisterRequest{
    private userProfile: UserProfile;
    private loginCredential: LoginCredential;
    
    /**
     * Getter $userProfile
     * @return {UserProfile}
     */
	public get $userProfile(): UserProfile {
		return this.userProfile;
	}

    /**
     * Getter $loginCredential
     * @return {LoginCredential}
     */
	public get $loginCredential(): LoginCredential {
		return this.loginCredential;
	}

    /**
     * Setter $userProfile
     * @param {UserProfile} value
     */
	public set $userProfile(value: UserProfile) {
		this.userProfile = value;
	}

    /**
     * Setter $loginCredential
     * @param {LoginCredential} value
     */
	public set $loginCredential(value: LoginCredential) {
		this.loginCredential = value;
	}
    
}