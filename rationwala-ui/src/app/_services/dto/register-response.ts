import { UserProfile } from "src/app/_models";
import { StatusInfo } from "./status-info";

export class RegisterResponse{
    private userProfile:UserProfile;
    private statusInfo:StatusInfo;
    public deserialize(o: Object): RegisterResponse {
        if (!o) return;
        Object.assign(this, o);
        this.$statusInfo = new StatusInfo().deserialize(this.$statusInfo);
        this.$userProfile = new UserProfile().deserialize(this.$userProfile);
        return this;
    }
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