package www.mall.PetCircle.Entity;

import java.util.List;

public class LikeModel {
    private String userId;
    private String ownerId;
    private String avatar;
    private String name;
    private Integer fansCount;
    private String registerTime;
    private String content;
    private List<String> petImages;
    private String images;
    private String petId;
    private String tag;
    private Integer likeCount;
    private Integer commentCount;

    public LikeModel(String userId, String ownerId, String avatar, String name, Integer fansCount, String registerTime, String content, List<String> petImages, String images, String petId, String tag, Integer likeCount, Integer commentCount) {
        this.userId = userId;
        this.ownerId = ownerId;
        this.avatar = avatar;
        this.name = name;
        this.fansCount = fansCount;
        this.registerTime = registerTime;
        this.content = content;
        this.petImages = petImages;
        this.images = images;
        this.petId = petId;
        this.tag = tag;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public LikeModel() {
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPetImages() {
        return petImages;
    }

    public void setPetImages(List<String> petImages) {
        this.petImages = petImages;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
