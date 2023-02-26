package ru.ksv.devices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksv.devices.model.Many;
import ru.ksv.devices.model.Post;
import ru.ksv.devices.service.PostService;

import java.util.List;

@RestController
public class PostRestController {
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "post")
    public ResponseEntity<List<Post>> findAll(){
        final List<Post> posts = postService.findAll();

        return posts != null && !posts.isEmpty()
                ? new ResponseEntity<>(posts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
