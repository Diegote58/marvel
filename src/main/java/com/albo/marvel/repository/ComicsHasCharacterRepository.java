package com.albo.marvel.repository;

import com.albo.marvel.entity.ComicHasCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComicsHasCharacterRepository extends JpaRepository<ComicHasCharacter, Long> {

	@Query("SELECT chc FROM ComicHasCharacter AS chc WHERE chc.comic.id = :comicId AND chc.character.id = :characterId")
	ComicHasCharacter findByComicIdAndCharacterId(@Param("comicId") Long comicId, @Param("characterId") Long characterId);

	@Query(value = "SELECT chc.* FROM Comic AS com JOIN comic_has_character AS chc on com.id = chc.comic_id JOIN character AS ch on ch.id = chc.character_id WHERE com.id IN (SELECT comic_id FROM comic_has_character where character_id= :characterId) AND ch.id != :characterId order by chc.last_modified desc", nativeQuery = true)
	List<ComicHasCharacter> findCharactersRelationshipByCharacterId(@Param("characterId") Long characterId);

}

