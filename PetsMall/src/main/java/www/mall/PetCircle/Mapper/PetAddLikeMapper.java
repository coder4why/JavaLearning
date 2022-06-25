package www.mall.PetCircle.Mapper;

import org.apache.ibatis.annotations.Insert;

public interface PetAddLikeMapper {

    @Insert("insert into LikeOwners(userId,ownerId) values(#{userId},#{ownerId})")
    public int addLike(String userId,String ownerId);

}
