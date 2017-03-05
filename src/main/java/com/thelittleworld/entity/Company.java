package com.thelittleworld.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "name", nullable = false, length = 40)
    public String name;

    @Column(name = "fury", nullable = false)
    public Double fury;

    @Column(name = "sociality", nullable = false)
    public Double sociality;

    @Column(name = "updated", nullable = false)
    public Date updated;

    @Column(name = "created", nullable = false)
    public Date created;

    @OneToMany
    @JoinColumn(name="company_id")
    public List<Member> members;

}
