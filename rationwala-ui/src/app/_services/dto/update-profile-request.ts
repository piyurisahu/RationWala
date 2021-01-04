import { UserProfile } from "src/app/_models";

export class UpdateProfileRequest{
    private userProfile:UserProfile;

    /**
     * Getter $userProfile
     * @return {UserProfile}
     */
	public get $userProfile(): UserProfile {
		return this.userProfile;
	}

    /**
     * Setter $userProfile
     * @param {UserProfile} value
     */
	public set $userProfile(value: UserProfile) {
		this.userProfile = value;
	}

}