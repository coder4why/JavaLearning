package www.mall.PetCircle.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.mall.PetCircle.Entity.RecommentTopicModel;

import java.util.List;

public interface RecommentTopicMapper {

    @Select("select * from Recomment_Items")
    @Results({
            @Result(column = "iconUrl",property = "iconUrl"),
            @Result(column = "title",property = "title"),
            @Result(column = "itemId",property = "itemId")
    })
    public List<RecommentTopicModel> selectAll();
}
