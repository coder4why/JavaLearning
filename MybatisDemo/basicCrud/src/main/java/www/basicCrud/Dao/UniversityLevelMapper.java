package www.basicCrud.Dao;

import org.apache.ibatis.annotations.*;
import www.basicCrud.Entity.University;
import www.basicCrud.Entity.UniversityLevel;
import java.util.List;

public interface UniversityLevelMapper<E> {

    /** 根据校名 一对一 查询：方式一*/
    @Select("select * from University_Level as le,University as Ui where le.name = Ui.name and le.name = #{name};")
    @Results({
            /** column:表示查询结果展示的列名，property：表示查询结果类的属性名称*/
            @Result(column = "level",property = "level"),
            @Result(column = "name",property = "name"),
            @Result(column = "level",property = "university.level"),
            @Result(column = "name",property = "university.name"),
            @Result(column = "address",property = "university.address"),
            @Result(column = "studentsCount",property = "university.studentsCount"),
            @Result(column = "teachersCount",property = "university.teachersCount")
    })
    public UniversityLevel selectUniversity(String name);

    /** 根据校名 一对一 查询：方式二*/
    @Select("select * from University_Level where name = #{name};")
    @Results({
            /** column:表示查询结果展示的列名，property：表示查询结果类的属性名称*/
            @Result(column = "level",property = "level"),
            @Result(column = "name",property = "name"),
            @Result(
                    column = "name",
                    property = "university",
                    javaType = University.class,
                    one = @One(select = "www.basicCrud.Dao.UniversityMapper.selectOne")
            )
    })
    public UniversityLevel selectOnlyOne(String name);

    /** 根据 level实现 一对多 查询：查询同类型的所有学校*/
    @Select("select * from University_Level where level = #{level};")
    @Results({
            /** column:表示查询结果展示的列名，property：表示查询结果类的属性名称*/
            @Result(column = "level",property = "level"),
            @Result(column = "name",property = "name"),
            @Result(
                    column = "level", //根据哪个字段去查询University表的数据
                    property = "universities", //要封装的属性名称
                    javaType = List.class, //要封装的实体类型
                    //select属性 代表查询那个接口的方法获得数据
                    many = @Many(select = "www.basicCrud.Dao.UniversityMapper.selectLevel")
            )
    })
    public UniversityLevel selectOne(String levelId);

    /** 查询全部*/
    @Select("select * from University_Level;")
    @Results({
            @Result(column = "level",property = "level"),
            @Result(column = "name",property = "name"),
            @Result(
                    column = "level",
                    property = "universities",
                    javaType = List.class,
                    many = @Many(select = "www.basicCrud.Dao.UniversityMapper.selectLevel")
            )
    })
    public List<UniversityLevel> selectAll();

}
