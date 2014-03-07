package learn.model;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import org.mongodb.morphia.annotations.Id;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午1:35
 */
public class User {
    @Id
    private long id;

    private String name;
    private boolean sex;
    private int age;
    private String address;

    public User(){}

    public User(long id,String name,boolean sex,int age,String address){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString(){
       return "[id:"+id+" name:"+name+" sex:"+sex+" age:"+age+" address:"+address+"]";
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
