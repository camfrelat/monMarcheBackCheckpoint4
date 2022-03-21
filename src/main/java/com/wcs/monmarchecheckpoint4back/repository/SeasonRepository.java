package com.wcs.monmarchecheckpoint4back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.monmarchecheckpoint4back.entity.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{

}
