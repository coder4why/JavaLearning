package www.mvc.model.service.impl;

import www.mvc.model.dao.impl.DaoImpl;
import www.mvc.model.entity.University;
import www.mvc.model.service.api.ServiceInterface;

import java.util.List;

public class ServiceImpl implements ServiceInterface<University> {
    private static DaoImpl dao = new DaoImpl();
    @Override
    public int insert(University university) {

        University university1 = dao.select(university.getName());
        if (university1 == null){

           return dao.insert(university);

        }else {

            System.out.println(university.getName()+"已存在");

        }
        return 0;
    }

    @Override
    public int delete(String name) {

        return dao.delete(name);

    }

    @Override
    public int update(University university) {
        return dao.update(university);
    }

    @Override
    public University select(String name) {
        return dao.select(name);
    }

    @Override
    public List<University> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<University> select(Integer pageIndex, Integer count) {
        return dao.select(pageIndex,count);
    }
}
