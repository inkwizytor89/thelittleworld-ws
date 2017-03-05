package com.thelittleworld.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer id;

    @Column(name = "login", unique = true, nullable = false, length = 40)
    public String login;

    @Column(name = "password", nullable = false, length = 60)
    public String password;

    @Column(name = "nick", nullable = false, length = 40)
    public String nick;

    @Column(name = "sex", nullable = false, length = 10)
    public String sex;

    @Column(name = "email", unique = true, nullable = false, length = 40)
    public String email;

    @Column(name = "updated")
    public Date updated;

    @Column(name = "created")
    public Date created;

    @Column(name = "company_id")
    public Integer companyId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    Company company;

}