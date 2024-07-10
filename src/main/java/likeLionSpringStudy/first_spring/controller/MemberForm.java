package likeLionSpringStudy.first_spring.controller;

public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        System.out.println("name setter");
        this.name= name;
    }

}
