package www.mall.PetCircle.Entity;

import java.util.List;

public class RecommendModel {
    private List<RecommentTopicModel> topItems;
    private List<RecommendPetModel> owners;

    public RecommendModel(List<RecommentTopicModel> topItems, List<RecommendPetModel> owners) {
        this.topItems = topItems;
        this.owners = owners;
    }

    public RecommendModel() {
    }

    public List<RecommentTopicModel> getTopItems() {
        return topItems;
    }

    public void setTopItems(List<RecommentTopicModel> topItems) {
        this.topItems = topItems;
    }

    public List<RecommendPetModel> getOwners() {
        return owners;
    }

    public void setOwners(List<RecommendPetModel> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "RecommendModel{" +
                "topItems=" + topItems +
                ", owners=" + owners +
                '}';
    }
}
