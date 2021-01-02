import { UserProfile } from "src/app/_models";
import { StatusInfo } from "./status-info";

export class GetAllSellerResponse {
    private sellerProfiles: UserProfile[];
    private statusInfo: StatusInfo;

    public deserialize(o: Object): GetAllSellerResponse {
        if (!o) return;
        Object.assign(this, o);
        this.$statusInfo = new StatusInfo().deserialize(this.$statusInfo);
        if (this.$sellerProfiles) {
            let sellerProfiles: UserProfile[] = new Array(this.$sellerProfiles.length);
            this.$sellerProfiles.forEach(x => { sellerProfiles.push(new UserProfile().deserialize(x)); sellerProfiles.shift() });
            this.$sellerProfiles = sellerProfiles;
        }
        return this;
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