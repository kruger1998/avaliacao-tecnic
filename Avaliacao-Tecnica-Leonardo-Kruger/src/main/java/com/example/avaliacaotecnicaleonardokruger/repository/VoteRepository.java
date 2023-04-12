package com.example.avaliacaotecnicaleonardokruger.repository;

import com.example.avaliacaotecnicaleonardokruger.dto.Vote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.List;

public interface VoteRepository extends ReactiveMongoRepository<Vote, String> {

    Mono<Boolean> existsByAssociateIdAndSubjectId(Long associateId, Long subjectId);

    Mono<List<Vote>> findAllBySubjectId(Long subjectId);

}
