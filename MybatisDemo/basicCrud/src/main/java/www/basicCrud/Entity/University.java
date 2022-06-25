package www.basicCrud.Entity;

public class University {

    private String name;
    private String address;
    private long level;
    private long studentsCount;
    private long teachersCount;

    public University(String name, String address, Integer level, Integer studentsCount, Integer teachersCount) {
        this.name = name;
        this.address = address;
        this.level = level;
        this.studentsCount = studentsCount;
        this.teachersCount = teachersCount;
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

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(long studentsCount) {
        this.studentsCount = studentsCount;
    }

    public long getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(long teachersCount) {
        this.teachersCount = teachersCount;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                ", studentsCount=" + studentsCount +
                ", teachersCount=" + teachersCount +
                '}';
    }
}
