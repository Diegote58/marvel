package com.albo.marvel.repository;

import com.albo.marvel.entity.ComicHasColaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicHasColaboratorRepository extends JpaRepository<ComicHasColaborator, Long> {

	@Query("SELECT chc FROM ComicHasColaborator AS chc WHERE chc.comic.id = :comicId AND chc.colaborator.id = :colaboratorId")
	ComicHasColaborator findByComicIdAndColaboratorId(@Param("comicId") long comicId, @Param("colaboratorId") long colaboratorId);

}

