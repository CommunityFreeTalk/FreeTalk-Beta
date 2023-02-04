package com.example.freetalk.community.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="f_dislike")
@ToString
public class Dislike {

    @EmbeddedId
    private LikeJPAEntity id;

    
}
