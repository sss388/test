package com.example.test.model.dto;

import com.example.test.model.entity.Post;
import com.example.test.model.entity.PostTag;
import com.example.test.model.entity.Tag;
import lombok.Data;

@Data
public class InsertPost {
    Post post;
    Tag tag;
}
