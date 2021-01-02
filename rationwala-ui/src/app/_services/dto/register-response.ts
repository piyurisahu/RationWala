import { UserProfile } from "src/app/_models";
import { StatusInfo } from "./status-info";

export class RegisterResponse{
    private userProfile:UserProfile;
    private statusInfo:StatusInfo;

    /**
     * Getter $userProfile
     * @return {UserProfile}
     */
	public get $userProfile(): UserProfile {
		return this.userProfile;
	}

    /**
     * Getter $statusInfo
     * @return {StatusInfo}
     */
	public get $statusInfo(): StatusInfo {
		return this.statusInfo;
	}

    /**
     * Setter $userProfile
     * @param {UserProfile} value
     */
	public set $userProfile(value: UserProfile) {
		this.userProfile = value;
	}

    /**
     * Setter $statusInfo
     * @param {StatusInfo} value
     */
	public set $statusInfo(value: StatusInfo) {
		this.statusInfo = value;
	}
    
}