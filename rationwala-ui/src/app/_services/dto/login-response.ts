import { UserProfile } from "src/app/_models";
import { ItemInventory } from "src/app/_models/item-inventory";
import { StatusInfo } from "./status-info";

export class LoginResponse {
    private token: string;
    private userProfile: UserProfile;
    private itemInventoryList: ItemInventory[];
    private staffProfiles: UserProfile[];
    private sellerProfiles: UserProfile[];
    private statusInfo: StatusInfo;

    public deserialize(o: Object): LoginResponse {
        if (!o) return;
        Object.assign(this, o);
        this.$userProfile = new UserProfile().deserialize(this.$userProfile);
        this.$statusInfo = new StatusInfo().deserialize(this.$statusInfo);

        if (this.$itemInventoryList) {
            let itemInventoryList: ItemInventory[] = new Array(10);
            this.$itemInventoryList.forEach(x => { itemInventoryList.push(new ItemInventory().deserialize(x)); itemInventoryList.shift() });
            this.$itemInventoryList = itemInventoryList;
        }

        if (this.$staffProfiles) {
            let staffProfiles: UserProfile[] = new Array(this.$staffProfiles.length);
            this.$staffProfiles.forEach(x => { staffProfiles.push(new UserProfile().deserialize(x)); staffProfiles.shift() });
            this.$staffProfiles = staffProfiles;
        }

        if (this.$sellerProfiles) {
            let sellerProfiles: UserProfile[] = new Array(this.$sellerProfiles.length);
            this.$sellerProfiles.forEach(x => { sellerProfiles.push(new UserProfile().deserialize(x)); sellerProfiles.shift() });
            this.$sellerProfiles = sellerProfiles;
        }


        return this;
    }
    /**
     * Getter $token
     * @return {string}
     */
    public get $token(): string {
        return this.token;
    }

    /**
     * Getter $userProfile
     * @return {UserProfile}
     */
    public get $userProfile(): UserProfile {
        return this.userProfile;
    }

    /**
     * Getter $itemInventoryList
     * @return {ItemInventory[]}
     */
    public get $itemInventoryList(): ItemInventory[] {
        return this.itemInventoryList;
    }

    /**
     * Getter $staffProfiles
     * @return {UserProfile[]}
     */
    public get $staffProfiles(): UserProfile[] {
        return this.staffProfiles;
    }

    /**
     * Getter $sellerProfiles
     * @return {UserProfile[]}
     */
    public get $sellerProfiles(): UserProfile[] {
        return this.sellerProfiles;
    }

    /**
     * Getter $statusInfo
     * @return {StatusInfo}
     */
    public get $statusInfo(): StatusInfo {
        return this.statusInfo;
    }

    /**
     * Setter $token
     * @param {string} value
     */
    public set $token(value: string) {
        this.token = value;
    }

    /**
     * Setter $userProfile
     * @param {UserProfile} value
     */
    public set $userProfile(value: UserProfile) {
        this.userProfile = value;
    }

    /**
     * Setter $itemInventoryList
     * @param {ItemInventory[]} value
     */
    public set $itemInventoryList(value: ItemInventory[]) {
        this.itemInventoryList = value;
    }

    /**
     * Setter $staffProfiles
     * @param {UserProfile[]} value
     */
    public set $staffProfiles(value: UserProfile[]) {
        this.staffProfiles = value;
    }

    /**
     * Setter $sellerProfiles
     * @param {UserProfile[]} value
     */
    public set $sellerProfiles(value: UserProfile[]) {
        this.sellerProfiles = value;
    }

    /**
     * Setter $statusInfo
     * @param {StatusInfo} value
     */
    public set $statusInfo(value: StatusInfo) {
        this.statusInfo = value;
    }

}