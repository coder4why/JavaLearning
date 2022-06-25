package www.mall.PetCircle.Entity;

public class RecommentTopicModel {

    private String iconUrl;
    private String title;
    private String itemId;

    public RecommentTopicModel(String iconUrl, String title, String itemId) {
        this.iconUrl = iconUrl;
        this.title = title;
        this.itemId = itemId;
    }

    public RecommentTopicModel() {
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "RecommentTopicModel{" +
                "iconUrl='" + iconUrl + '\'' +
                ", title='" + title + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
