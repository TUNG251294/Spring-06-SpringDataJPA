package com.example.repository;

import com.example.model.Song;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JPASongRepository implements IJPASongRepository{
    @PersistenceContext
    private EntityManager em;

//    @Override
//    public List<Song> findAll() {
//        TypedQuery<Song> query = em.createQuery("select s from Song s", Song.class);
//        return query.getResultList();
//    }
    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = em.createNamedQuery("FIND_ALL",Song.class);
        return query.getResultList();
    }

//    @Override
//    public Song findById(Long id) {
//        Song song = em.find(Song.class,id);
//        if(song != null){   //only mindset, ngan gon return song truc tiep k if
//            return song;
//        }
//        return null;
//    }
@Override
public Song findById(Long id) {
    String sql = "select s from Song s where s.id = :id";
//    String sql = "from Song s where id = ?0";
    TypedQuery<Song> query = em.createQuery(sql, Song.class)
            .setParameter("id",id);
//            .setParameter(0,id);
    return query.getSingleResult();
}
//gop chung create & update vao chung method
    @Override
    public void save(Song song) {
        if(song.getId() != null){
            em.merge(song);
        } else{
            em.persist(song);
        }
    }

    @Override
    public void remove(Long id) {
        Song song = findById(id);
        if(song != null){
            em.remove(id);
        }
    }

}
