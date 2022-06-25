package www.mall.Personal.Mapper;

import org.apache.ibatis.annotations.*;
import www.mall.Personal.Entity.PersonModel;

public interface PersonalMapper {

    @Select("select * from User_Accounts where userId = #{userId}")
    @Results({
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "nickName", property = "nickName"),
            @Result(column = "atavar", property = "atavar")
        }
    )
    public PersonModel getUserInfo(String user_id);

    /** 抛出异常：拦截相同账号注册*/
    @Insert("insert into User_Accounts(account,password,userId,nickName)values(#{account},#{password},#{userId},#{nickName})")
    public int registerAccount(String account,String password,String userId,String nickName) throws Exception;

    @Select("select * from User_Accounts where account = #{account} and password = #{password}")
    @Results({
            @Result(column = "account",property = "account"),
            @Result(column = "password",property = "password"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "nickName",property = "nickName"),
            @Result(column = "atavar",property = "atavar")
        }
    )
    public PersonModel login(String account,String password);

    @Update("update User_Accounts set password = #{newPassword} where account = #{account}")
    public int resetPassword(String account,String newPassword) throws Exception;

}
