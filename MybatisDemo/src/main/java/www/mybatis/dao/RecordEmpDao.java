package www.mybatis.dao;

import java.util.List;

public interface RecordEmpDao<T> {

    public int insert(T t);
    public T selectOne(String emp_id);
    public List<T> selectAll();

}
