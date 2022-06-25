package www.mall.PetCircle.Entity;

public class RecommendPetModel {
    private String ownerId;
    private String avatar;
    private String name;
    private Integer fansCount;
    private String registerTime;
    private String content;
    private String videoUrl;

    private String petId;
    private String tag;
    private Integer likeCount;
    private Integer commentCount;

    public RecommendPetModel(String ownerId, String avatar, String name, Integer fansCount, String registerTime, String content, String videoUrl, String petId, String tag, Integer likeCount, Integer commentCount) {
        this.ownerId = ownerId;
        this.avatar = avatar;
        this.name = name;
        this.fansCount = fansCount;
        this.registerTime = registerTime;
        this.content = content;
        this.videoUrl = videoUrl;
        this.petId = petId;
        this.tag = tag;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public RecommendPetModel() {
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    @Override
    public String toString() {
        return "RecommendPetModel{" +
                "ownerId='" + ownerId + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", fansCount=" + fansCount +
                ", registerTime='" + registerTime + '\'' +
                ", content='" + content + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", petId='" + petId + '\'' +
                ", tag='" + tag + '\'' +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                '}';
    }
}
