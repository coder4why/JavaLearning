package www.mall.PetCircle.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.mall.PetCircle.Entity.RecommendPetModel;

import java.util.List;

public interface RecommendPetMapper {

    @Select("select * from Recomment_Lists")
    @Results({
            @Result(column = "ownerId",property = "ownerId"),
            @Result(column = "avatar",property = "avatar"),
            @Result(column = "name",property = "name"),
            @Result(column = "fansCount",property = "fansCount"),

            @Result(column = "registerTime",property = "registerTime"),
            @Result(column = "content",property = "content"),
            @Result(column = "videoUrl",property = "videoUrl"),
            @Result(column = "petId",property = "petId"),

            @Result(column = "tag",property = "tag"),
            @Result(column = "likeCount",property = "likeCount"),
            @Result(column = "commentCount",property = "commentCount")

    })
    public List<RecommendPetModel> selectPets();
}
