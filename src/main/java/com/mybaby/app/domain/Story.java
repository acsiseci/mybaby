package com.mybaby.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "seq_story", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story extends BaseEntity{

    @Column(name = "title")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    private String image;

    @Column(name = "reading_time")
    private String readingTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "published")
    private boolean published;
}
