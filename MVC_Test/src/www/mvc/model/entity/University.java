package www.mvc.model.entity;

public class University {
    private String name;
    private String address;
    private String level;
    private String studentsCount;
    private String teachersCount;

    public University() {
    }

    public University(String name, String address, String level, String studentsCount, String teachersCount) {
        this.name = name;
        this.address = address;
        this.level = level;
        this.studentsCount = studentsCount;
        this.teachersCount = teachersCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(String studentsCount) {
        this.studentsCount = studentsCount;
    }

    public String getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(String teachersCount) {
        this.teachersCount = teachersCount;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", studentsCount='" + studentsCount + '\'' +
                ", teachersCount='" + teachersCount + '\'' +
                '}';
    }
}


