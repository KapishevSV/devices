package ru.ksv.devices.service;

import ru.ksv.devices.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
}
