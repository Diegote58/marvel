package com.albo.marvel.repository;

import com.albo.marvel.entity.CharacterConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterConfigRepository extends JpaRepository<CharacterConfig, Long> {

	@Query("SELECT ch FROM CharacterConfig ch WHERE ch.code = :code")
	CharacterConfig getByCode(@Param("code") String code);
}

