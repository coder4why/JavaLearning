package www.basicCrud.Dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.basicCrud.Entity.Classes;
import www.basicCrud.Entity.Teachers;

import java.util.List;

public interface TeacherMapper {

    /** 根据teacher_id查询一位老师*/
    @Select("select * from TeacherNames where teacher_id = #{teacher_id};")
    @Results({
            @Result(column = "teacher_id",property = "teacher_id"),
            @Result(column = "name",property = "name")
    })
    public Teachers selectOne(Integer teacher_id);

    /** 根据class_id查询一位老师*/
    @Select("select * from TeacherNames tn,Classes_Teachers ct where tn.teacher_id = ct.teacher_id and ct.class_id = #{class_id};")
    @Results({
            @Result(column = "teacher_id",property = "teacher_id"),
            @Result(column = "name",property = "name")
    })
    public List<Teachers> selectTeachers(Integer class_id);

    /** 根据teacher_id查询一位老师*/
    @Select("select * from Classes_Teachers ct,ClassNames cn where ct.class_id = cn.class_id and ct.teacher_id = #{teacher_id};")
    @Results({
            @Result(column = "class_id",property = "class_id"),
            @Result(column = "name",property = "name")
    })
    public List<Classes> selectClasses(Integer teacher_id);

    /** 查询所有任课老师:及其所带班级*/
    @Select("select * from TeacherNames tn,Classes_Teachers ct,ClassNames cn where tn.teacher_id = ct.teacher_id and ct.class_id = cn.class_id;")
    @Results({
            @Result(column = "teacher_id",property = "teacher_id"),
            @Result(column = "name",property = "name"),
            @Result(
                    column = "teacher_id",
                    property = "classes",
                    javaType = List.class,
                    many = @Many(select = "www.basicCrud.Dao.TeacherMapper.selectClasses")
            )
    })
    public List<Teachers> selectAllTeachers();

}
