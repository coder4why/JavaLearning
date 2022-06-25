package www.mybatis.dao;

import java.util.List;

public interface UniversityDao<T> {

    public int insert(T t);
    public int delete(String name);
    public int update(T t);
    public T selectOne(String name);
    public List<T> selectAll();

}
