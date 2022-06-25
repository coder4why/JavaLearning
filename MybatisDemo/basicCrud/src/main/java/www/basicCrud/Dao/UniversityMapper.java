package www.basicCrud.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import www.basicCrud.Entity.University;

import java.util.List;

public interface UniversityMapper<E> {

    @Insert("insert into University(name,address,level,studentsCount,teachersCount)values(#{name},#{address},#{level},#{studentsCount},#{teachersCount});")
    public int insert(E e);

    @Delete("delete from University where name = #{name};")
    public int delete(String uniqueId);

    @Update("update University set address = #{address},level = #{level}, studentsCount=#{studentsCount},teachersCount = #{teachersCount} where name = #{name};")
    public int update(E e);

    @Select("select * from University where name = #{name};")
    public University selectOne(String uniqueId);

    @Select("select * from University where level = #{level};")
    public List<University> selectLevel(String level);

    @Select("select * from University;")
    public List<University> selectAll();

}
