package org.marathon.code.competition.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11)")
    private Long id;

    @Column(columnDefinition = "varchar(20)")
    private String username;

    @Column(length = 32, columnDefinition = "char(32)")
    private String md5Password;

    @Column(columnDefinition = "bit default 0")
    private Boolean sex;

    @Column(columnDefinition = "varchar(30)")
    private String displayName;
}
