package com.example.test.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "POST_TAG")
public class PostTag {
    //게시물 태그 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_TAG_ID")
    private int board_tag_id;

    //글번호
    @OneToOne
    @JoinColumn(name = "POST_NO", referencedColumnName = "POST_NO")
    private Post post_no;

    //게시판(분류) 코드
    @ManyToOne
    @JoinColumn(name = "BOARD_CD", referencedColumnName = "BOARD_CD")
    private BoardDef board_cd;

    //태그 ID
    @OneToOne
    @JoinColumn(name = "TAG_NO", referencedColumnName = "TAG_NO")
    private Tag tag_no;
}
