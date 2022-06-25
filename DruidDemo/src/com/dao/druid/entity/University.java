package com.dao.druid.entity;

public class University {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String address;
    private int level;
    private int studentsCount;
    private int teachersCount;

    /** 使用Apache的QueryRunner必须添加无参构造方法 */
    public University() {
    }

    public University(String name, String address, int level, int studentsCount, int teachersCount) {
        this.name = name;
        this.address = address;
        this.level = level;
        this.studentsCount = studentsCount;
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
