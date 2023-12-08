package com.example.test.controller;

import com.example.test.model.dto.InsertPost;
import com.example.test.model.dto.UpdatePost;
import com.example.test.model.entity.BoardDef;
import com.example.test.model.entity.Post;
import com.example.test.model.entity.PostTag;
import com.example.test.model.entity.Tag;
import com.example.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    //글 쓰기
    @PostMapping("/insert")
    public String insertBoard(@RequestBody InsertPost insertPost){
        insertPost.getPost().setReg_dt(LocalDateTime.now());

        Post post = boardService.savePost(insertPost.getPost());
        Tag tag = boardService.getTag(insertPost.getTag().getTag_no());
        BoardDef boardDef = boardService.getBoardDef(insertPost.getPost().getBoard_no().getBoard_cd());

        PostTag postTag = new PostTag();
        postTag.setBoard_cd(boardDef);
        postTag.setPost_no(post);
        postTag.setTag_no(tag);

        boardService.savePostTag(postTag);

        return postTag.toString();
    }

    //글 수정
    @PutMapping("/update")
    public String updateBoard(@RequestBody UpdatePost post){

        return boardService.changePost(post).toString();
    }

    //글 삭제
    @DeleteMapping("/delete")
    public void deleteBoard(@RequestParam("id") int id) {
        boardService.deletePost(id);
    }

    //글 page별로 글 불러오기
    @GetMapping("/read")
    public List<Post> readBoard(@RequestParam(value = "page", defaultValue = "1") int page) {
        return boardService.getPosts(page);
    }

}
