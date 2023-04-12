package com.example.avaliacaotecnicaleonardokruger.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenSessonRequest {

    private Long subjectId;
    private LocalDateTime endTime;

}
