package ru.ksv.devices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksv.devices.model.Post;
import ru.ksv.devices.repository.PostRepo;

import java.util.List;

@Service
public class PostServiceImp implements PostService {
    private PostRepo postRepo;

    @Autowired
    public PostServiceImp(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepo.findAll();
    }
}
