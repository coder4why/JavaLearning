package www.aop.Entity.pointCut;

import java.util.List;

public interface PointCutService<T> {

    public Integer insert(T t);
    public Integer delete(T t);
    public Integer update(T t);
    public T select(String name);
    public List<T> selectAll();

}
