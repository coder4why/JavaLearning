package www.basicCrud.Entity;

import java.util.List;

public class UniversityLevel {
    public long level;
    public String name;
    public List<University> universities;
    //根据level查询的一个随机的学校：
    public University university;

    public UniversityLevel(long level, String name, List<University> universities, University university) {
        this.level = level;
        this.name = name;
        this.universities = universities;
        this.university = university;
    }

    public UniversityLevel(long level, String name, University university) {
        this.level = level;
        this.name = name;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UniversityLevel() {
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    @Override
    public String toString() {
        return "UniversityLevel{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", universities=" + universities +
                ", university=" + university +
                '}';
    }
}
