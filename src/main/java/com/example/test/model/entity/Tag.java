package com.example.test.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TAG")
@Data
public class Tag {
    //태그 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_NO")
    private int tag_no;

    //태그
    @Column(name = "TAG")
    private String tag;

    //게시판(분류) 코드
    @ManyToOne
    @JoinColumn(name = "BOARD_CD", referencedColumnName = "BOARD_CD")
    private BoardDef board_cd;
}
