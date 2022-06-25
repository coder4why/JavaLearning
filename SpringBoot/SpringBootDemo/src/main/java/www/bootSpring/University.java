package www.bootSpring;

public class University {

    private String name;
    private String address;
    private Integer level;
    private Integer teachersCount;
    private Integer studentsCount;

    public University(String name, String address, Integer level, Integer teachersCount, Integer studentsCount) {
        this.name = name;
        this.address = address;
        this.level = level;
        this.teachersCount = teachersCount;
        this.studentsCount = studentsCount;
    }

    public University() {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(Integer teachersCount) {
        this.teachersCount = teachersCount;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                ", teachersCount=" + teachersCount +
                ", studentsCount=" + studentsCount +
                '}';
    }
}
