package www.basicCrud.Dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.basicCrud.Entity.Classes;

import java.util.List;

public interface TeacherClassMapper {

    /** 实现 多对多 查询： 一个班级对应的多个任课老师 */
    @Select("select * from ClassNames where class_id = #{class_id};")
    @Results({
            @Result(column = "class_id",property = "class_id"),
            @Result(column = "name",property = "name"),
            @Result(
                    column = "class_id",
                    property = "teachers",
                    javaType = List.class,
                    many = @Many(select =
                            "www.basicCrud.Dao.TeacherMapper.selectTeachers"
                    )
            )
    })
    public List<Classes> selectOneClass(Integer class_id);


    /** 查询所有班级对应的老师*/
    /** 实现 多对多 查询： 每个个班级对应的多个任课老师 */
    @Select("select * from ClassNames;")
    @Results({
            @Result(column = "class_id",property = "class_id"),
            @Result(column = "name",property = "name"),
            @Result(
                    column = "class_id",
                    property = "teachers",
                    javaType = List.class,
                    many = @Many(select =
                            "www.basicCrud.Dao.TeacherMapper.selectTeachers"
                    )
            )
    })
    public List<Classes> selectAll();


}
