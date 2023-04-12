package com.example.avaliacaotecnicaleonardokruger.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    private Boolean open;
    private LocalDateTime endTime;

}
