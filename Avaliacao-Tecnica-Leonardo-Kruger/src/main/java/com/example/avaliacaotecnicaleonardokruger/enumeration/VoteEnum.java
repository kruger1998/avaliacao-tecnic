package com.example.avaliacaotecnicaleonardokruger.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum VoteEnum {

    SIM("Sim"), NAO("Não");

    private final @Getter String value;

}
