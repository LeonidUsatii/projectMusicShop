package de.ait.repositories.musics;

import de.ait.models.Music;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface MusicsRepository extends CrudRepository<Music> {
    @Override
    List<Music> findAll();

    @Override
    void save(Music model);

    @Override
    Music findById(String id);
}
