package com.akvone.dao;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Song;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


//@javax.transaction.Transactional
@Repository
public class SongDAO extends HibernateDaoSupport implements ISongDAO {

    @Transactional
    public boolean add(Song song) {
        if (getHibernateTemplate().find("select * from Song song where song.id = " + song.getId()).isEmpty()) {
            getHibernateTemplate().save(song);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Song song) {
        getHibernateTemplate().update(song);
    }

    @Transactional(readOnly = true)
    public Song findById(Long id) {
        return getHibernateTemplate().get(Song.class, id);
    }

    @Transactional
    public void delete(Song song) {
        getHibernateTemplate().delete(song);
    }

    @Transactional(readOnly = true)
    public Set<Song> findAll() {
        return new HashSet(getHibernateTemplate().find("FROM com.akvone.entity.Song"));
    }

}
