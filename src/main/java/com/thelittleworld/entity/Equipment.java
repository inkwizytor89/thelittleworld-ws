package com.thelittleworld.entity;

import javax.persistence.*;

@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @Column(name="companion_id")
    public Integer companionId;

    @OneToOne
    @JoinColumn(name ="main_hand")
    public Item mainHand;

    @OneToOne
    @JoinColumn(name ="off_hand")
    public Item offHand;

    @OneToOne
    @JoinColumn(name="head")
    public Item head;

    @OneToOne
    @JoinColumn(name="shoulders")
    public Item shoulders;

    @OneToOne
    @JoinColumn(name="chest")
    public Item chest;

    @OneToOne
    @JoinColumn(name="wrist")
    public Item wrist;

    @OneToOne
    @JoinColumn(name="hands")
    public Item hands;

    @OneToOne
    @JoinColumn(name="waist")
    public Item waist;

    @OneToOne
    @JoinColumn(name="legs")
    public Item legs;

    @OneToOne
    @JoinColumn(name="feet")
    public Item feet;

    @OneToOne
    @JoinColumn(name="cloak")
    public Item cloak;

    @OneToOne
    @JoinColumn(name="neck")
    public Item neck;

    @OneToOne
    @JoinColumn(name="first_ring")
    public Item firstRing;

    @OneToOne
    @JoinColumn(name="second_ring")
    public Item secondRing;
}
