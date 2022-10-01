package com.yakidan.spring.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "emotions_point")
public class EmotionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    public EmotionPoint(Emotion type, Integer scaleLevel, String description, User user, Date creationDateTime) {
        this.type = type;
        this.scaleLevel = scaleLevel;
        this.description = description;
        this.user = user;
        this.creationDateTime = creationDateTime;
    }

    @OneToOne
    @JoinColumn(name = "type")
    private Emotion type;

    @Column(name = "scale_level")
    private Integer scaleLevel;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    public EmotionPoint() {

    }
}
