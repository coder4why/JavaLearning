package www.mall.Personal.Dao;

import org.apache.ibatis.session.SqlSession;
import www.mall.Base.BaseDao;
import www.mall.Personal.Entity.PersonModel;
import www.mall.Personal.Mapper.PersonalMapper;

import java.util.HashMap;
import java.util.Map;

public class PersonalDao extends BaseDao {

    public Map getMineData(String user_id) {

        SqlSession sqlSession = sessionFactory.openSession(true);

        PersonalMapper mapper = sqlSession.getMapper(PersonalMapper.class);
        PersonModel personModel = mapper.getUserInfo(user_id);

        sqlSession.close();

        Map response = new HashMap();
        response.put("code",personModel == null ? 0:200);
        response.put("message",personModel == null ?"登录失败":"登录成功");
        if (personModel != null) {
            response.put("body", personModel);
        }

        return response;

    }

    public Map registerAccount(String mobile,String password,String vertifyCode){

        String userId = "pet_"+mobile;
        String nickName = "宠窝—"+mobile;

        SqlSession sqlSession = sessionFactory.openSession(true);

        PersonalMapper mapper = sqlSession.getMapper(PersonalMapper.class);
        int i = 0;
        /** 拦截相同账号注册*/
        try {
            i = mapper.registerAccount(mobile, password, userId, nickName);
        } catch (Exception exception) {
            exception.printStackTrace();
            sqlSession.close();
        }finally {
            sqlSession.close();
            if (i==1){
                return login(mobile,password);
            }else {

                Map response = new HashMap();
                response.put("code", 0);
                response.put("message", "注册失败");
                return response;

            }
        }

    }

    public Map login(String mobile,String password){

        SqlSession sqlSession = sessionFactory.openSession(true);

        PersonalMapper mapper = sqlSession.getMapper(PersonalMapper.class);
        PersonModel personModel = mapper.login(mobile, password);

        sqlSession.close();

        Map response = new HashMap();
        response.put("code",personModel != null?200:0);
        response.put("message",personModel != null?"登录成功":"账号或密码输入错误，请重试");
        if (personModel != null) {
            response.put("body", personModel);
        }
        return response;

    }

    public Map resetPassword(String mobile,String newPassword){

        SqlSession sqlSession = sessionFactory.openSession(true);

        PersonalMapper mapper = sqlSession.getMapper(PersonalMapper.class);
        int i = 0;
        try {
            i = mapper.resetPassword(mobile, newPassword);
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            sqlSession.close();
            Map response = new HashMap();

            response.put("code",i == 1 ? 200:0);
            response.put("message",i == 1?"密码修改成功":"密码修改失败");
            return response;
        }

    }
}
