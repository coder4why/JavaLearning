package www.mybatis.dao;

import java.util.List;
/** 1、使用Mybatis代理模式，实现DAO操作，定义interface，Mapper.xml文件指定 namespace为协议路径，id为协议方法名称，即可*/
public interface UniversityMybatisDao<T> {

    public int insert(T t);
    public int delete(String name);
    public int update(T t);
    public T selectOne(String name);
    public List<T> selectAll();

}
