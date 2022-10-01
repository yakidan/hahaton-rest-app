package com.yakidan.spring.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "emotion")
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;

}
