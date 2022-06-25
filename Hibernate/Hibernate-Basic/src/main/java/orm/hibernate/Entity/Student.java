package orm.hibernate.Entity;

import javax.persistence.*;

/** 标记为Hibernate实体类*/
@Entity
/** 标记该实体类在数据库中的表名称*/
@Table(name = "Hibernate_Student")
public class Student {

    /** 标记为主键*/
    @Id
    /** 标记主键ID在数据库中的colume为sid*/
    @Column(name="sid")
    /** 标记主键为自增张*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "studentNo")
    private String studentNo;

    public Student(String name, int age, String studentNo) {
        this.name = name;
        this.age = age;
        this.studentNo = studentNo;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentNo='" + studentNo + '\'' +
                '}';
    }
}
