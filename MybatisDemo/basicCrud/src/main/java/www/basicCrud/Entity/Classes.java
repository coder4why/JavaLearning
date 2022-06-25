package www.basicCrud.Entity;

import java.util.List;

public class Classes {

    public Integer class_id;
    public String name;
    /** 一个班级 的多个任课老师*/
    public List<Teachers> teachers;

    public Classes(Integer class_id, String name, List<Teachers> teachers) {
        this.class_id = class_id;
        this.name = name;
        this.teachers = teachers;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }

    public Classes(Integer class_id, String name) {
        this.class_id = class_id;
        this.name = name;
    }

    public Classes() {
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "class_id=" + class_id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
