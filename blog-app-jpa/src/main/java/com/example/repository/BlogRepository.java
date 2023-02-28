package com.example.repository;

import com.example.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        Blog blog = em.find(Blog.class,id);
        if(blog != null){
            return blog;
        }
        return null;
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId() != null){
            em.merge(blog);
        }else{
            em.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if(blog != null){
            em.remove(blog);
        }
    }
}
