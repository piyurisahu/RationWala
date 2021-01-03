import { ProfilePicture } from "./profile-picture";

export class UserProfile {
    private profilePicture:ProfilePicture;
	private userProfileId:number;
	private firstName:string;
	private lastName:string;
	private email:string;
	private phoneNumber:number;
	private addressLine1:string;
    private addressLine2:string;
    private city:string;
    private zipcode:number;
	private sellerProfile:boolean;
	private sellerBusinessName:string;
    
    public deserialize(o: Object): UserProfile{
        if(!o)return;
        Object.assign(this, o);
        this.$profilePicture = new ProfilePicture().deserialize(this.profilePicture);
        return this;
    }
    
    /**
     * Getter $profilePicture
     * @return {ProfilePicture}
     */
	public get $profilePicture(): ProfilePicture {
		return this.profilePicture;
	}

    /**
     * Getter $userProfileId
     * @return {number}
     */
	public get $userProfileId(): number {
		return this.userProfileId;
	}

    /**
     * Getter $firstName
     * @return {string}
     */
	public get $firstName(): string {
		return this.firstName;
	}

    /**
     * Getter $lastName
     * @return {string}
     */
	public get $lastName(): string {
		return this.lastName;
	}

    /**
     * Getter $email
     * @return {string}
     */
	public get $email(): string {
		return this.email;
	}

    /**
     * Getter $phoneNumber
     * @return {number}
     */
	public get $phoneNumber(): number {
		return this.phoneNumber;
	}

    /**
     * Getter $addressLine1
     * @return {string}
     */
	public get $addressLine1(): string {
		return this.addressLine1;
	}

    /**
     * Getter $addressLine2
     * @return {string}
     */
	public get $addressLine2(): string {
		return this.addressLine2;
	}

    /**
     * Getter $city
     * @return {string}
     */
	public get $city(): string {
		return this.city;
	}

    /**
     * Getter $zipcode
     * @return {number}
     */
	public get $zipcode(): number {
		return this.zipcode;
	}

    /**
     * Getter $sellerProfile
     * @return {boolean}
     */
	public get $sellerProfile(): boolean {
		return this.sellerProfile;
	}

    /**
     * Getter $sellerBusinessName
     * @return {string}
     */
	public get $sellerBusinessName(): string {
		return this.sellerBusinessName;
	}

    /**
     * Setter $profilePicture
     * @param {ProfilePicture} value
     */
	public set $profilePicture(value: ProfilePicture) {
		this.profilePicture = value;
	}

    /**
     * Setter $userProfileId
     * @param {number} value
     */
	public set $userProfileId(value: number) {
		this.userProfileId = value;
	}

    /**
     * Setter $firstName
     * @param {string} value
     */
	public set $firstName(value: string) {
		this.firstName = value;
	}

    /**
     * Setter $lastName
     * @param {string} value
     */
	public set $lastName(value: string) {
		this.lastName = value;
	}

    /**
     * Setter $email
     * @param {string} value
     */
	public set $email(value: string) {
		this.email = value;
	}

    /**
     * Setter $phoneNumber
     * @param {number} value
     */
	public set $phoneNumber(value: number) {
		this.phoneNumber = value;
	}

    /**
     * Setter $addressLine1
     * @param {string} value
     */
	public set $addressLine1(value: string) {
		this.addressLine1 = value;
	}

    /**
     * Setter $addressLine2
     * @param {string} value
     */
	public set $addressLine2(value: string) {
		this.addressLine2 = value;
	}

    /**
     * Setter $city
     * @param {string} value
     */
	public set $city(value: string) {
		this.city = value;
	}

    /**
     * Setter $zipcode
     * @param {number} value
     */
	public set $zipcode(value: number) {
		this.zipcode = value;
	}

    /**
     * Setter $sellerProfile
     * @param {boolean} value
     */
	public set $sellerProfile(value: boolean) {
		this.sellerProfile = value;
	}

    /**
     * Setter $sellerBusinessName
     * @param {string} value
     */
	public set $sellerBusinessName(value: string) {
		this.sellerBusinessName = value;
	}

}
export enum StaffAuthType {
    ADMIN, INVENTORY, DELIVERY
}
