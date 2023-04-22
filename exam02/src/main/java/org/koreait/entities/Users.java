package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.commons.constants.UserType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data   // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@Entity
@Table(name="members", indexes={    //엔티티와 매핑할 테이블을 지정, name: 테이블명을 명시
        @Index(name="idx_user_name", columnList = "userNm"),    // name:필드와 매핑할 컬럼의 이름 설정
        @Index(name="idx_reg_dt_desc", columnList="regDt DESC")
})
public class Users  extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) // 기본값: AUTO (생략가능)
    //@TableGenerator(name="users_seq", initialValue = 1, allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.TABLE)
    private Long userNo;

    @Column(length=45, nullable=false, unique=true)
    private String userId;
    @Column(length=65, nullable=false)
    private String userPw;
    @Column(length=40, nullable = false)    // name: DB에 추가되는 컬럼명을 바꿀 수 있다.
    private String userNm;

    @Column(length=11)
    private String mobile;

    //@Transient  // 필드 생성 무시
    @Column(length=100)
    private String email;
    @Lob
    private String intro;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private UserType type = UserType.USER;

    @OneToMany(mappedBy = "user")   // 연관관계의 주인 명시 PostData :: user
    private List<PostData> postDatas = new ArrayList<>();
}
