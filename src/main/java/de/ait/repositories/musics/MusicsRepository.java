package de.ait.repositories.musics;

import de.ait.models.Music;
import de.ait.models.Product;
import de.ait.repositories.CrudRepository;

import java.util.List;

public interface MusicsRepository extends CrudRepository<Music> {
    @Override
    List<Music> findAll();

    @Override
    void save(Music model);

    @Override
    Music findByTitle(String title);

    void update(Music updatedGood);

    void delete(Music deleteGood);
}
