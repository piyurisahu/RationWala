export class ProfilePicture{
    private sellerLogoUrl:string;
    public deserialize(o: Object): ProfilePicture{
        if(!o)return;
        Object.assign(this, o);
        return this;
    }
}