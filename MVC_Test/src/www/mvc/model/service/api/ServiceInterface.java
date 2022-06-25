package www.mvc.model.service.api;

import java.util.List;

public interface ServiceInterface<T> {

    int insert(T t);
    int delete(String name);
    int update(T t);

    T select(String name);

    List<T> selectAll();
    /** 分页查询*/
    List<T> select(Integer pageIndex,Integer count);


}
