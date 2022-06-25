package www.mall.PetCircle.Dao;
import org.apache.ibatis.session.SqlSession;
import www.mall.Base.BaseDao;
import www.mall.PetCircle.Entity.LikeModel;
import www.mall.PetCircle.Entity.RecommendModel;
import www.mall.PetCircle.Entity.RecommendPetModel;
import www.mall.PetCircle.Entity.RecommentTopicModel;
import www.mall.PetCircle.Mapper.LikePetsMapper;
import www.mall.PetCircle.Mapper.PetAddLikeMapper;
import www.mall.PetCircle.Mapper.RecommendPetMapper;
import www.mall.PetCircle.Mapper.RecommentTopicMapper;

import java.util.*;

public class CircleDao extends BaseDao {

    public Map getLikePets(String user_id){

        SqlSession sqlSession = sessionFactory.openSession(true);
        LikePetsMapper mapper = sqlSession.getMapper(LikePetsMapper.class);
        List<LikeModel> likeModels = mapper.selectAll(user_id);

        for (LikeModel model:likeModels
             ) {
            List<String> petImages = new ArrayList<>();
            if (model.getImages()!=null && model.getImages().length()>0 && model.getImages().contains("&#&")){
                List<String> imgs = Arrays.asList(model.getImages().split("&#&"));
                for (String pic :
                        imgs) {
                    pic = pic.replace(" ","");
                    pic = pic.replace("\n","");
                    petImages.add(pic);
                }
            }else {
                petImages.add(model.getImages());
            }
            model.setPetImages(petImages);
        }

        sqlSession.close();

        Map response = new HashMap();
        response.put("code",200);
        response.put("message","请求成功");
        response.put("body", likeModels);

        return response;

    }

    public Map getRecommentPets() {

        SqlSession sqlSession = sessionFactory.openSession(true);
        RecommentTopicMapper mapper = sqlSession.getMapper(RecommentTopicMapper.class);
        List<RecommentTopicModel> topicModels = mapper.selectAll();

        RecommendPetMapper petMapper = sqlSession.getMapper(RecommendPetMapper.class);
        List<RecommendPetModel> recommendPetModels = petMapper.selectPets();

        RecommendModel recommendModel = new RecommendModel();
        recommendModel.setTopItems(topicModels);
        recommendModel.setOwners(recommendPetModels);

        sqlSession.close();
        Map response = new HashMap();
        response.put("code",200);
        response.put("message","请求成功");
        response.put("body", recommendModel);

        return response;

    }

    public Map addLike(String user_id,String owner_id){

        SqlSession sqlSession = sessionFactory.openSession(true);
        PetAddLikeMapper mapper = sqlSession.getMapper(PetAddLikeMapper.class);
        int update = mapper.addLike(user_id, owner_id);

        sqlSession.close();
        Map response = new HashMap();
        response.put("code",update == 1 ? 200 : 0);
        response.put("message",update == 1 ?"关注成功":"关注失败");

        return response;

    }

}
