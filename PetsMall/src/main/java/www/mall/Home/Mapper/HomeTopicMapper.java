package www.mall.Home.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.mall.Home.Entity.HomePetNewsModel;
import www.mall.Home.Entity.HomeTopicModel;

import java.util.List;

public interface HomeTopicMapper {
    @Select("select * from HotTopics")
    @Results({
            @Result(column = "imageUrl", property = "imageUrl"),
            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description")
    })
    public List<HomeTopicModel> selectHotTopics();
}
