package com.hamze.reactivelabr2dbc.domain.entity;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

public interface IBaseEntity<I extends Serializable> extends Persistable<I> {
    public Class<I> getPkType();
}
