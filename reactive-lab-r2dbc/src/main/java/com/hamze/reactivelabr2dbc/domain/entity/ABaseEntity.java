package com.hamze.reactivelabr2dbc.domain.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class ABaseEntity<I extends Serializable> implements IBaseEntity<I> {

    private transient Class<I> pkType;

    protected boolean isNew = true;


}