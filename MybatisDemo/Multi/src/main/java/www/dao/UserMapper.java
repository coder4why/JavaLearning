package www.dao;

import java.util.List;

public interface UserMapper<T> {
//    public int insert(T t);
//    public int delete(String uid);
//    public int update(T t);
    public T selectOne(String uid);
    public List<T> selectAll();
}
