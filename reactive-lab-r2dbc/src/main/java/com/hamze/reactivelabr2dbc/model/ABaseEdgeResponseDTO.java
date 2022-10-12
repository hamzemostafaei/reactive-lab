package com.hamze.reactivelabr2dbc.model;

import lombok.Data;

import java.io.Serializable;
@Data
public abstract class ABaseEdgeResponseDTO<R> implements Serializable {

    private boolean successful;

    private String error;

    private R responseData;

}
