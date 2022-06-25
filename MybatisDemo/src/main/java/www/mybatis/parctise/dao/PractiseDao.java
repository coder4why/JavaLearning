package www.mybatis.parctise.dao;

import java.util.List;

public interface PractiseDao<T> {

    public int insert(T t);
    public int delete(String name);
    public int update(T t);
    /** 单个查询*/
    public T selectOne(String name);
    /** 条件判断查询多个*/
    public List<T> selectMore(String name,String address);
    /** 查询多个*/
    public List<T> selectMoreWithList(List<String> names);
    /** 查询全部*/
    public List<T> selectAll();

}
