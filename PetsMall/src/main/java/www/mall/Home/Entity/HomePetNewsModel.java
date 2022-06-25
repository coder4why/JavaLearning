package www.mall.Home.Entity;

public class HomePetNewsModel {
    private String petId;
    private String image;
    private String title;

    private String description;
    private String postTime;
    private Long readCount;

    public HomePetNewsModel(String petId, String image, String title, String description, String postTime, Long readCount) {
        this.petId = petId;
        this.image = image;
        this.title = title;
        this.description = description;
        this.postTime = postTime;
        this.readCount = readCount;
    }

    public HomePetNewsModel() {
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "HomePetNewsModel{" +
                "petId='" + petId + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", postTime='" + postTime + '\'' +
                ", readCount=" + readCount +
                '}';
    }
}
