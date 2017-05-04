package com.thelittleworld.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_roles")
public class UserRole{

    @Id
    public Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
    @Column(name = "user_id", nullable = false)
    public Long userId;

    @Column(name = "role", nullable = false, length = 45)
    public String role;

    @Column(name = "created")
    public Date created;

}
