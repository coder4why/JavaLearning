package www.mvc.model.dao.api;

import java.util.List;

public interface DaoInterface<T> {

    int insert(T t);
    int delete(String name);
    int update(T t);

    /** 单个查询*/
    T select(String name);
    /** 所有查询*/
    List<T> selectAll();
    /** 分页查询*/
    List<T> select(Integer pageIndex,Integer count);


}
