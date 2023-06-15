package com.hamze.reactivelabblocking.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class ABaseVersionedEntity {

    @Basic
    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Basic
    @Column(name = "CREATION_DATE", nullable = false)
    private Timestamp creationDate;

    @Basic
    @Column(name = "CREATOR_USER_ID", nullable = false)
    private Long creatorUserId;

    @Basic
    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @Basic
    @Column(name = "UPDATER_USER_ID")
    private Long updaterUserId;

    @PrePersist
    protected void handlePrePersist() {

        this.creatorUserId = 1L;

        // Using System.currentTimeMillis() seems to result in double calculation of DST in Linux-based systems
        this.creationDate = new Timestamp(new Date().getTime());

    }

    @PreUpdate
    protected void handlePreUpdate() {

        this.updaterUserId = 1L;

        // Using System.currentTimeMillis() seems to result in double calculation of DST in Linux-based systems
        this.lastUpdate = new Timestamp(new Date().getTime());
    }

}