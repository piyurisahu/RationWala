import { _Start } from "@angular/cdk/scrolling";
import { StatusInfo } from "./status-info";

export class PlaceOrderResponse{
    private statusInfo:StatusInfo;

    public deserialize(o: Object): PlaceOrderResponse {
        if (!o) return;
        Object.assign(this, o);
        this.$statusInfo = new StatusInfo().deserialize(this.$statusInfo);
        return this;
    }
    /**
     * Getter $statusInfo
     * @return {StatusInfo}
     */
	public get $statusInfo(): StatusInfo {
		return this.statusInfo;
	}

    /**
     * Setter $statusInfo
     * @param {StatusInfo} value
     */
	public set $statusInfo(value: StatusInfo) {
		this.statusInfo = value;
	}

}