package www.mybatis.Entity;

public class University {

    private String name;
    private String address;
    private int level;
    private int studentsCount;
    private int teachersCount;

    @Override
    public String toString() {
        return "\nUniversity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", studentsCount='" + studentsCount + '\'' +
                ", teachersCount='" + teachersCount + '\'' +
                '}';
    }

    public University() {
    }

    public University(String name, String address, int level, int studentsCount, int teachersCount) {
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(int teachersCount) {
        this.teachersCount = teachersCount;
    }
}
