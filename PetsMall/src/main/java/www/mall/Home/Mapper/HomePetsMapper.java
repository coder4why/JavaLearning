package www.mall.Home.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.mall.Home.Entity.HomePetNewsModel;

import java.util.List;

public interface HomePetsMapper {
    @Select("select * from PetNews")
    @Results({
            @Result(column = "petId", property = "petId"),
            @Result(column = "image", property = "image"),

            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),

            @Result(column = "postTime", property = "postTime"),
            @Result(column = "readCount", property = "readCount")
    })
    public List<HomePetNewsModel> selectPetNews();

}
