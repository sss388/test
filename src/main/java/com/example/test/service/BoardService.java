package com.example.test.service;

import com.example.test.model.dto.UpdatePost;
import com.example.test.model.entity.BoardDef;
import com.example.test.model.entity.Post;
import com.example.test.model.entity.PostTag;
import com.example.test.model.entity.Tag;
import com.example.test.repository.BoardDefRepository;
import com.example.test.repository.PostRepository;
import com.example.test.repository.PostTagRepository;
import com.example.test.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final BoardDefRepository boardDefRepository;
    private final PostTagRepository postTagRepository;

    //글 저장
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public Post changePost(UpdatePost updatePost) {
        Post originPost = postRepository.findById(updatePost.getPost_no()).get();

        // 글 내용 변경
        if(updatePost.getPost_cn() != null) {
            originPost.setPost_cn(updatePost.getPost_cn());
        }

        // 글 제목 변경
        if(updatePost.getPost_sj() != null) {
            originPost.setPost_sj(updatePost.getPost_sj());
        }

        return postRepository.save(originPost);
    }

    //태그 가져오기
    public Tag getTag(int tagNo) {
        return tagRepository.findById(tagNo).get();
    }

    //BoardDef 가져오기
    public BoardDef getBoardDef(String boardCd) {
        return boardDefRepository.findById(boardCd).get();
    }

    //PostTag 추가
    public PostTag savePostTag(PostTag postTag) {
        return postTagRepository.save(postTag);
    }

    // 글 삭제
    public void deletePost(int id) {
        int postId = postTagRepository.findById(id).get().getPost_no().getPost_no();

        postTagRepository.deleteById(id);
        postRepository.deleteById(postId);
    }

    // 글 읽어오기
    public List<Post> getPosts(int page) {
        Pageable pageable = PageRequest.of(page - 1, 10); // page는 0부터 시작하므로 -1을 해줍니다.
        Page<Post> postPage = postRepository.findAll(pageable);

        return postPage.getContent();
    }
}
