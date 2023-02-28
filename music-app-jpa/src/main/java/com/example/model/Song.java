package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
@NamedQuery(name= "FIND_ALL",query = "select s from Song s")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;
    private String category;
    private String access;

    public Song() {
    }

    public Song(Long id, String name, String singer, String category, String access) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
