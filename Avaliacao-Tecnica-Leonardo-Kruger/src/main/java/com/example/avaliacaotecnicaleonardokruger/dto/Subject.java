package com.example.avaliacaotecnicaleonardokruger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    private Long id;
    private String name;
    private String description;
    private Session session;

}
