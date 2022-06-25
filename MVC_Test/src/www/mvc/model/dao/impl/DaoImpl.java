package www.mvc.model.dao.impl;

import www.mvc.model.dao.api.DaoInterface;
import www.mvc.model.entity.University;
import www.mvc.model.utils.DbUtils;

import java.util.List;

public class DaoImpl implements DaoInterface<University> {

    private static DbUtils<University> dbUtils = new DbUtils<>();

    @Override
    public int insert(University university) {

        String sql = "insert into University(name,address,level,studentsCount,teachersCount)values(?,?,?,?,?)";
        Object[] params = {university.getName(),university.getAddress(),university.getLevel(),
                university.getStudentsCount(),university.getTeachersCount()};
        return dbUtils.commonSQL(sql,params);

    }

    @Override
    public int delete(String name) {

        String sql = "delete from University where name = ?";
        return dbUtils.commonSQL(sql,name);

    }

    @Override
    public int update(University university) {

        String sql = "update University set address = ?,level = ?,studentsCount = ?,teachersCount = ? where name = ?";
        Object[] parmas = {university.getAddress(),university.getLevel(),university.getStudentsCount(),
                university.getTeachersCount(),university.getName()};
        return dbUtils.commonSQL(sql,parmas);
    }

    @Override
    public University select(String name) {

        String sql = "select * from University where name = ?";
        List<University> universities = dbUtils.select(sql,new University(),name);
        if (universities != null && universities.size()>0){
            return universities.get(0);
        }
        return null;
    }

    @Override
    public List<University> selectAll() {
        String sql = "select * from University";
        List<University> universities = dbUtils.select(sql,new University());
        return universities;
    }

    @Override
    public List<University> select(Integer pageIndex, Integer count) {
        Integer index = pageIndex;
        if (pageIndex<=0){
            index = 1;
        }
        Integer startIndex = (index - 1 )* count;
        Object[] params = {startIndex,count};
        String sql = "select * from University limit ?,?";
        List<University> universities = dbUtils.select(sql,new University(),params);
        return universities;

    }
}
