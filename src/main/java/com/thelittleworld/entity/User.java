package com.thelittleworld.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "login", unique = true, nullable = false, length = 40)
    public String login;

    @Column(name = "nick", nullable = false, length = 40)
    public String nick;

    @Column(name = "sex", nullable = false, length = 10)
    public String sex;

    @Column(name = "email", unique = true, nullable = false, length = 40)
    public String email;

    @Column(name = "data_version")
    public Date dataVersion;

    @Column(name = "updated")
    public Date updated;

    @Column(name = "created")
    public Date created;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    public List<UserRole> userRoles;

}