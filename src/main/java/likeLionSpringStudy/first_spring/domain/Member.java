package likeLionSpringStudy.first_spring.domain;


import jakarta.persistence.*;

@Entity
public class Member {

    // IDENTITY: DB에서 알아서 ID를 생성해주는 것
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // column명이 name이기 때문에 따로 annotation 필요 없음
    // 원래는 annotation을 보고 db와 매핑, 변수명==칼럼명이면 따로 그럴 필요 X
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
