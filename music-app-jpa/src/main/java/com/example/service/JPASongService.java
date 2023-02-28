package com.example.service;

import com.example.model.Song;
import com.example.repository.IJPASongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JPASongService implements SongService{
    @Autowired
    private IJPASongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepository.remove(id);
    }
}
