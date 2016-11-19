package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.akvone.dao.*;
import java.util.HashSet;
import java.util.Set;


@Repository
public class SongDAOImpl implements SongDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public boolean add(Song song) {
        if (hibernateTemplate.find("from Song song where song.id = " + song.getId()).isEmpty()) {
            hibernateTemplate.save(song);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Song song) {
        hibernateTemplate.update(song);
    }

    @Transactional(readOnly = true)
    public Song findById(Long id) {
        return hibernateTemplate.get(Song.class, id);
    }

    @Transactional
    public void delete(Song song) {
        hibernateTemplate.delete(song);
    }

    @Transactional(readOnly = true)
    public Set<Song> findAll() {
        return new HashSet(hibernateTemplate.find("FROM Song"));
    }

}
