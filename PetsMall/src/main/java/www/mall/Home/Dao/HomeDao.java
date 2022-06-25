package www.mall.Home.Dao;

import org.apache.ibatis.session.SqlSession;
import www.mall.Base.BaseDao;
import www.mall.Home.Entity.HomeBannerModel;
import www.mall.Home.Entity.HomeModel;
import www.mall.Home.Entity.HomePetNewsModel;
import www.mall.Home.Entity.HomeTopicModel;
import www.mall.Home.Mapper.HomeBannerMapper;
import www.mall.Home.Mapper.HomePetsMapper;
import www.mall.Home.Mapper.HomeTopicMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeDao extends BaseDao {

    public HomeModel selectAll(){

        SqlSession sqlSession = sessionFactory.openSession(true);

        /** 使用 Mybatis实现 */
        HomeBannerMapper mapper = sqlSession.getMapper(HomeBannerMapper.class);
        List<HomeBannerModel> homeBannerModels = mapper.selectBanners();

        HomeTopicMapper topicMapper = sqlSession.getMapper(HomeTopicMapper.class);
        List<HomeTopicModel> topicModels = topicMapper.selectHotTopics();

        HomePetsMapper petsMapper = sqlSession.getMapper(HomePetsMapper.class);
        List<HomePetNewsModel> petNewsModels = petsMapper.selectPetNews();

        HomeModel homeModel = new HomeModel();
        homeModel.setBanners(homeBannerModels);
        homeModel.setHotTopics(topicModels);
        homeModel.setPetNews(petNewsModels);

        sqlSession.close();

        return homeModel;

    };
    public Map getHomeDatas() {

        HomeModel homeModel = selectAll();

        Map response = new HashMap();
        response.put("code",200);
        response.put("message","请求成功");
        response.put("body", homeModel);

        return response;
    }

}
