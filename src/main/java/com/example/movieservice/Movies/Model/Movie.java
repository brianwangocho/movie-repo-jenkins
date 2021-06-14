package com.example.movieservice.Movies.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity(name="movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer id;


    @Column(name = "name",unique = true)
    public String name;

    @Column(name="genre")
    public  String genre;


    @Column(name="rating")
    public  int rating;

    @Column(name="released_on")
    public  Date releasedOn;


}
