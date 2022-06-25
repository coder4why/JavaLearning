package www.mall.Base;

import org.apache.ibatis.session.SqlSessionFactory;
import www.mall.DbConfig.DbSessionFactory;
import www.mall.Home.Mapper.HomeBannerMapper;
import www.mall.Home.Mapper.HomePetsMapper;
import www.mall.Home.Mapper.HomeTopicMapper;
import www.mall.Personal.Mapper.PersonalMapper;
import www.mall.PetCircle.Mapper.LikePetsMapper;
import www.mall.PetCircle.Mapper.PetAddLikeMapper;
import www.mall.PetCircle.Mapper.RecommendPetMapper;
import www.mall.PetCircle.Mapper.RecommentTopicMapper;

public class BaseDao {

    protected static SqlSessionFactory sessionFactory = DbSessionFactory.getInstance().getSessionFactory();

    /**
     * jar运行错误:Mapper is  not known to the MapperRegistry
     * 主要要注意的是比如要注册，也就是这行代码：
     */
    static {
//
//        sessionFactory.getConfiguration().addMapper(HomeBannerMapper.class);
//        sessionFactory.getConfiguration().addMapper(HomePetsMapper.class);
//        sessionFactory.getConfiguration().addMapper(HomeTopicMapper.class);
//
//        sessionFactory.getConfiguration().addMapper(PersonalMapper.class);
//        sessionFactory.getConfiguration().addMapper(LikePetsMapper.class);
//        sessionFactory.getConfiguration().addMapper(PetAddLikeMapper.class);
//
//        sessionFactory.getConfiguration().addMapper(RecommendPetMapper.class);
//        sessionFactory.getConfiguration().addMapper(RecommentTopicMapper.class);

    }
}
