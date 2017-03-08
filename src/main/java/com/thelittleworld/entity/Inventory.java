package com.thelittleworld.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    @Column(name="companion_id")
    public Integer companionId;

    @OneToOne
    @JoinColumn(name ="item_id")
    public Item item;

    @Column(name ="efficiency")
    public Double efficiency;

    @Column(name = "created")
    public Date created;
}
