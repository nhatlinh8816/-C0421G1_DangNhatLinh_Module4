package com.example.demo.model.service;

import com.example.demo.model.entity.Song;
import com.example.demo.model.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImp implements SongService {
    @Autowired
    private SongRepo songRepo;
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepo.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }
}
