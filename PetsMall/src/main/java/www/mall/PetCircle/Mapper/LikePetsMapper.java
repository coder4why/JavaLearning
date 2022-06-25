package www.mall.PetCircle.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.mall.PetCircle.Entity.LikeModel;

import java.util.List;

public interface LikePetsMapper {

    @Select("select * from MyLike_List where userId = #{userId}")
    @Results({
            @Result(column = "userId",property = "userId"),
            @Result(column = "ownerId",property = "ownerId"),
            @Result(column = "avatar",property = "avatar"),

            @Result(column = "name",property = "name"),
            @Result(column = "fansCount",property = "fansCount"),
            @Result(column = "registerTime",property = "registerTime"),

            @Result(column = "images",property = "images"),
            @Result(column = "petId",property = "petId"),
            @Result(column = "tag",property = "tag"),
            @Result(column = "likeCount",property = "likeCount"),
            @Result(column = "commentCount",property = "commentCount"),
    })
    public List<LikeModel> selectAll(String user_id);
}
