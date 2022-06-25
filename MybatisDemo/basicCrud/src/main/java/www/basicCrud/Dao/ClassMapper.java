package www.basicCrud.Dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import www.basicCrud.Entity.Classes;

import java.util.List;

public interface ClassMapper {

    /** 根据class_id查询 class*/
    @Select("select * from ClassNames where class_id = #{class_id};")
    @Results({
            @Result(column = "class_id",property = "class_id"),
            @Result(column = "name",property = "name")
    })
    public Classes selectOne(Integer class_id);

    /** 查询所有 class*/
    @Select("select * from ClassNames;")
    @Results({
            @Result(column = "class_id",property = "class_id"),
            @Result(column = "name",property = "name")
    })
    public List<Classes> selectAll();


}
