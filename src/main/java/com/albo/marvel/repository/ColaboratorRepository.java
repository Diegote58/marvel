package com.albo.marvel.repository;

import com.albo.marvel.entity.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ColaboratorRepository extends JpaRepository<Colaborator, Long> {

	@Query("SELECT col FROM Colaborator AS col WHERE col.role = :role AND col.name = :name")
	List<Colaborator> findByRoleAndName(@Param("role") String role, @Param("name") String name);

	@Query("SELECT DISTINCT col FROM Colaborator AS col " +
			"JOIN col.comicHasColaboratorList AS chc " +
			"JOIN chc.comic AS com " +
			"JOIN com.comicsHasCharacterList AS chchar " +
			"WHERE chchar.character.id = :id ORDER BY col.lastModified DESC")
	List<Colaborator> findByCharacterId(@Param("id") Long id);

}

