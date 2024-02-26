package thespeace.servlet.basic;

import lombok.Getter;
import lombok.Setter;

//JSON 형식으로 파싱하기 위한 객체
@Getter @Setter
public class HelloData {

    private String username;
    private int age;

/*    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { //java property 접근법
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
}
