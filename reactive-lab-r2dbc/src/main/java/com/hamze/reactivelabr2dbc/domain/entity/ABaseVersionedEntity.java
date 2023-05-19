package com.hamze.reactivelabr2dbc.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter

public abstract class ABaseVersionedEntity<I extends Serializable> extends ABaseEntity<I> {

    @Column("VERSION")
    private Long version;

    @Column("CREATION_DATE")
    private Timestamp creationDate;

    @Column("CREATOR_USER_ID")
    private Long creatorUserId;

    @Column("LAST_UPDATE")
    private Timestamp lastUpdate;

    @Column("UPDATER_USER_ID")
    private Long updaterUserId;

}