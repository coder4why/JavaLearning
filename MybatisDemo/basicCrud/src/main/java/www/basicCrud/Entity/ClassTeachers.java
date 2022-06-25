package www.basicCrud.Entity;

public class ClassTeachers {
    public Integer class_id;
    public Integer teacher_id;

    public ClassTeachers(Integer class_id, Integer teacher_id) {
        this.class_id = class_id;
        this.teacher_id = teacher_id;
    }

    public ClassTeachers() {
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "ClassTeachers{" +
                "class_id=" + class_id +
                ", teacher_id=" + teacher_id +
                '}';
    }
}
