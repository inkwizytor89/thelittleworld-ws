package com.thelittleworld.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "companions")
public class Companion {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "name", nullable = false, length = 40)
    public String name;

    @Column(name = "fury", nullable = false)
    public Double fury;

    @Column(name = "sociality", nullable = false)
    public Double sociality;

    @Column(name = "sex", nullable = false)
    public String sex;

    @Column(name = "strength", nullable = false)
    public Double strength;

    @Column(name = "agility", nullable = false)
    public Double agility;

    @Column(name = "stamina", nullable = false)
    public Double stamina;

    @Column(name = "intelligence", nullable = false)
    public Double intelligence;

    @Column(name = "wisdom", nullable = false)
    public Double wisdom;

    @Column(name = "charisma", nullable = false)
    public Double charisma;

    @Column(name = "updated", nullable = false)
    public Date updated;

    @Column(name = "created", nullable = false)
    public Date created;

    @OneToOne
    @PrimaryKeyJoinColumn
    public Equipment equipment;
}
