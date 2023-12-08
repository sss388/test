package com.example.test.model.dto;


import lombok.Data;

@Data
public class UpdatePost {
    // 변경할 글 번호
    private int post_no;

    // 변경할 글 제목
    private String post_sj;

    // 변경할 글 내용
    private String post_cn;
}
