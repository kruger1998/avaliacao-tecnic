package com.example.avaliacaotecnicaleonardokruger.request;

import com.example.avaliacaotecnicaleonardokruger.enumeration.VoteEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteRequest {

    private Long associateId;
    private Long subjectId;
    private VoteEnum voteEnum;

}
