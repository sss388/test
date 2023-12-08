package com.example.test.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "POST")
public class Post {

    //글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_NO")
    private int post_no;

    //게시판(분류) 코드
    @ManyToOne
    @JoinColumn(name = "BOARD_NO", referencedColumnName = "BOARD_CD")
    private BoardDef board_no;

    //제목
    @Column(name = "POST_SJ")
    private String post_sj;

    //내용
    @Column(name = "POST_CN")
    private String post_cn;

    //작성자 ID
    @Column(name = "REGSTR_ID")
    private String regstr_id;

    //작성일시
    @Column(name = "REG_DT")
    private LocalDateTime reg_dt;
}
