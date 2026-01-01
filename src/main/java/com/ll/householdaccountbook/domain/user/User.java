package com.ll.householdaccountbook.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    private LocalDateTime create_at;
    private LocalDateTime update_at;





    ///id	BIGINT	PK	사용자 고유 식별자
    //email	VARCHAR(255)	UNIQUE, NOT NULL	로그인용 이메일
    //password	VARCHAR(255)	NOT NULL	암호화된 비밀번호
    //name	VARCHAR(50)	NOT NULL	사용자 이름
    //created_at	DATETIME	NOT NULL	회원 가입 시각
    //updated_at	DATETIME	NOT NULL	회원 정보 수정 시각
}
