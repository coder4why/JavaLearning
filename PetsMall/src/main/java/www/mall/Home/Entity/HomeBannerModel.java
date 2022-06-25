package www.mall.Home.Entity;

public class HomeBannerModel {

    private String imageUrl;
    private String linkUrl;

    public HomeBannerModel(String imageUrl, String linkUrl) {
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
    }

    public HomeBannerModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    @Override
    public String toString() {
        return "HomeBannerModel{" +
                "imageUrl='" + imageUrl + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                '}';
    }
}
