package com.example.avaliacaotecnicaleonardokruger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private long yesVotes;
    private long noVotes;

}
