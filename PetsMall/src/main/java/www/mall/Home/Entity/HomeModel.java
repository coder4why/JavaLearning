package www.mall.Home.Entity;

import java.util.List;

public class HomeModel {

    private List<HomeBannerModel> banners;
    private List<HomeTopicModel> hotTopics;
    private List<HomePetNewsModel> petNews;

    public HomeModel(List<HomeBannerModel> banners, List<HomeTopicModel> hotTopics, List<HomePetNewsModel> petNews) {
        this.banners = banners;
        this.hotTopics = hotTopics;
        this.petNews = petNews;
    }

    public HomeModel() {
    }

    public List<HomeBannerModel> getBanners() {
        return banners;
    }

    public void setBanners(List<HomeBannerModel> banners) {
        this.banners = banners;
    }

    public List<HomeTopicModel> getHotTopics() {
        return hotTopics;
    }

    public void setHotTopics(List<HomeTopicModel> hotTopics) {
        this.hotTopics = hotTopics;
    }

    public List<HomePetNewsModel> getPetNews() {
        return petNews;
    }

    public void setPetNews(List<HomePetNewsModel> petNews) {
        this.petNews = petNews;
    }
}