package www.mybatis.Entity;

import java.util.Date;

//name varchar(20) not null,
//        emp_id varchar(20) unique not null,
//        mobile varchar(11) unique not null,
//        birthday bigint not null,

public class RecordEmp {
    private String name;
    private String emp_id;
    private String mobile;
    /** 测试将Date类型存储到数据库且存储类型为bigint类型*/
    private Date birthday;

    public RecordEmp(String name, String emp_id, String mobile, Date birthday) {
        this.name = name;
        this.emp_id = emp_id;
        this.mobile = mobile;
        this.birthday = birthday;
    }

    public RecordEmp() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nRecordEmp{" +
                "name='" + name + '\'' +
                ", emp_id='" + emp_id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", birthday=" + birthday +
                "}\n";
    }
}
