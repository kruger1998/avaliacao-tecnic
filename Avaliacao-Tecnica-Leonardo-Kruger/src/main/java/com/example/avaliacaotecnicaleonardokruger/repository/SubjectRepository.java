package com.example.avaliacaotecnicaleonardokruger.repository;

import com.example.avaliacaotecnicaleonardokruger.dto.Subject;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SubjectRepository extends ReactiveMongoRepository<Subject, String> {

    Mono<Subject> findSubjectById(Long id);

}
