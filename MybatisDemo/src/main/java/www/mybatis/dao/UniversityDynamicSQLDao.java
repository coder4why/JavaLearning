package www.mybatis.dao;

import java.util.List;

public interface UniversityDynamicSQLDao<T> {

    //where 多条件查询
    T selectOne(String name,String address,String level);

    //foreach 传入names String数组，查询多条记录：
    List<T> selectNames(List<String> names);



}
