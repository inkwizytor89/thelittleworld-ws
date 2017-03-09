package com.thelittleworld.entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "name", nullable = false, length = 40)
    public String name;

    @Column(name = "description", nullable = false, length = 256)
    public String description;

    @Column(name = "type", nullable = false)
    public String type;

    @Column(name = "weight", nullable = false)
    public Double weight;

    @OneToOne
    @JoinColumn(name ="id", referencedColumnName="item_id")
    public Weapon weapon;

    @OneToOne
    @JoinColumn(name ="id", referencedColumnName="item_id")
    public Armor armor;
}
