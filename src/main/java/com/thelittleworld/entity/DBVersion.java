package com.thelittleworld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "db_version")
public class DBVersion {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "items_version")
    public Date itemsVersion;

    @Column(name = "created")
    public Date created;
}