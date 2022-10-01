package com.yakidan.spring.spring_boot.service;


import com.yakidan.spring.spring_boot.entity.EmotionPoint;
import com.yakidan.spring.spring_boot.entity.User;
import com.yakidan.spring.spring_boot.repository.EmotionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmotionPointService {

    @Autowired
    EmotionPointRepository repository;

    public List<EmotionPoint> getAllEmotionPoint() {
        return repository.findAll();
    }

    public EmotionPoint getEmotionPointById(int id) {
        Optional<EmotionPoint> pointOptional = repository.findById(id);

        if (pointOptional.isPresent())
            return pointOptional.get();

        throw new RuntimeException("this emotionPoint not found");
    }


    public List<EmotionPoint> getAllEmotionPointByUser(int id) {
        return repository.findByUserId(id);
    }

    public EmotionPoint saveEmotionPointWithUser(EmotionPoint point, User user, Date date) {
        EmotionPoint point1 = new EmotionPoint(point.getType(),
                point.getScaleLevel(),
                point.getDescription(),
                user,
                date);
        return repository.save(point1);
    }
}
