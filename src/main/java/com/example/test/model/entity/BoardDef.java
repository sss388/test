package com.example.test.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BOARD_DEF")
public class BoardDef {
    //게시판(분류) 코드
    @Id
    @Column(name = "BOARD_CD")
    private String board_cd;

    //게시판(분류) 이름
    @Column(name = "BOARD_NM")
    private String board_nm;
}
