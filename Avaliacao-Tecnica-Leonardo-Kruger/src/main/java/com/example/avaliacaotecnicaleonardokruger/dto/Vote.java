package com.example.avaliacaotecnicaleonardokruger.dto;

import com.example.avaliacaotecnicaleonardokruger.enumeration.VoteEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    @Id
    private Long associateId;
    private Long subjectId;
    private VoteEnum voteEnum;

}
