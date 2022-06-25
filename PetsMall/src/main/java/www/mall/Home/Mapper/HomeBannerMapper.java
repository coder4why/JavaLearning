package www.mall.Home.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.mall.Home.Entity.HomeBannerModel;

import java.util.List;

public interface HomeBannerMapper {

    @Select("select * from HomeBanners")
    @Results({
            @Result(column = "imageUrl", property = "imageUrl"),
            @Result(column = "linkUrl", property = "linkUrl")
    })
    public List<HomeBannerModel> selectBanners();

}
