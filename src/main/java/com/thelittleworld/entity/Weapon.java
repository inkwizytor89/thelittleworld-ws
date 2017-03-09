package com.thelittleworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weapons")
public class Weapon {

    @Id
    @Column(name = "item_id", unique = true, nullable = false)
    public Integer itemId;

    @Column(name = "type", nullable = false, length = 40)
    public String type;

    @Column(name = "damage", nullable = false)
    public Double damage;

    @Column(name = "armor", nullable = false)
    public String armor;

    @Column(name = "bonus_id")
    public String bonusId;
}