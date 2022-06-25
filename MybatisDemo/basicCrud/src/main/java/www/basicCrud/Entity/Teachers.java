package www.basicCrud.Entity;

import java.util.List;

public class Teachers {

    public String name;
    public Integer teacher_id;
    /** 一个老师 带的多个班级*/
    public List<Classes> classes;

    public Teachers(String name, Integer teacher_id, List<Classes> classes) {
        this.name = name;
        this.teacher_id = teacher_id;
        this.classes = classes;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public Teachers(String name, Integer teacher_id) {
        this.name = name;
        this.teacher_id = teacher_id;
    }

    public Teachers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "name='" + name + '\'' +
                ", teacher_id=" + teacher_id +
                ", classes=" + classes +
                '}';
    }
}
