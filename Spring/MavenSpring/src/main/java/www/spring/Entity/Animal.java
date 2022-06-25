package www.spring.Entity;

import java.util.*;

public class Animal {

    private String name;
    private Integer age;
    private Date bornDate;
    private String[] hobbys;
    private Set<String> phones;
    private List<String> names;
    private Map<String,String> countries;
    private Properties files;

    public Animal() {
        System.out.println("调用了无参构造-Animal");
    }

    public Animal(String name, Integer age, Date bornDate, String[] hobbys, Set<String> phones, List<String> names, Map<String, String> countries, Properties files) {
        System.out.println("调用了有参构造-Animal");
        this.name = name;
        this.age = age;
        this.bornDate = bornDate;
        this.hobbys = hobbys;
        this.phones = phones;
        this.names = names;
        this.countries = countries;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public Properties getFiles() {
        return files;
    }

    public void setFiles(Properties files) {
        this.files = files;
    }
}
