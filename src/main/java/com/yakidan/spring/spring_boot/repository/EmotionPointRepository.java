package com.yakidan.spring.spring_boot.repository;

import com.yakidan.spring.spring_boot.entity.EmotionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmotionPointRepository
        extends JpaRepository<EmotionPoint, Integer> {

    @Query("select p from EmotionPoint p where p.user.id=?1")
    List<EmotionPoint> findByUserId(int id);
}
