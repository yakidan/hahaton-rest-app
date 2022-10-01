package com.yakidan.spring.spring_boot.controler;

import com.yakidan.spring.spring_boot.entity.EmotionPoint;
import com.yakidan.spring.spring_boot.entity.User;
import com.yakidan.spring.spring_boot.service.EmotionPointService;
import com.yakidan.spring.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/point")
public class EmotionPointController {

    @Autowired
    private EmotionPointService emotionPointService;

    @Autowired
    private UserService userService;


    @GetMapping()
    public List<EmotionPoint> getAllEmotionPoint() {
        return emotionPointService.getAllEmotionPoint();
    }

    @GetMapping("/user/{id}")
    public List<EmotionPoint> getAllEmotionPointByUser(@PathVariable int id) {
        return emotionPointService.getAllEmotionPointByUser(id);
    }

    @GetMapping("/{id}")
    public EmotionPoint getAllEmotionPoint(@PathVariable int id) {
        return emotionPointService.getEmotionPointById(id);
    }

    @PostMapping("/user/{id}")
    public EmotionPoint createEmotionPointByUser(@RequestBody EmotionPoint point,
                                                 @PathVariable int id) {
        User user = userService.getUserById(id);
        return emotionPointService.saveEmotionPointWithUser(point, user,new Date());
    }
}
