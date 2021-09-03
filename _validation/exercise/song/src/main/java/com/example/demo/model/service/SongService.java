package com.example.demo.model.service;

import com.example.demo.model.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {
    Page<Song> findAll(Pageable pageable);
    void save(Song song);
}
