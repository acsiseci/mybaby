package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "story")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    private String name;
    @Lob
    @Column(name = "content")
    private String content;
    @Column(name = "image")
    private String image;
    @Column(name = "reading_time")
    private int readingTime;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "published")
    private boolean published;


}
