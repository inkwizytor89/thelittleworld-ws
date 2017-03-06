package com.thelittleworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "name", nullable = false, length = 40)
    public String name;

    @Column(name = "description", nullable = false, length = 40)
    public String description;

    @Column(name = "type", nullable = false)
    public String type;

    @Column(name = "weight", nullable = false)
    public Double weight;
}
