package com.example.demo.model.repository;

import com.example.demo.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song,Integer> {

}
