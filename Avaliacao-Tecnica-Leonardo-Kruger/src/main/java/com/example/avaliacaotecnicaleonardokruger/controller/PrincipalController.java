package com.example.avaliacaotecnicaleonardokruger.controller;

import com.example.avaliacaotecnicaleonardokruger.dto.Result;
import com.example.avaliacaotecnicaleonardokruger.dto.Subject;
import com.example.avaliacaotecnicaleonardokruger.dto.Vote;
import com.example.avaliacaotecnicaleonardokruger.request.OpenSessonRequest;
import com.example.avaliacaotecnicaleonardokruger.request.ResultRequest;
import com.example.avaliacaotecnicaleonardokruger.request.SubjectRequest;
import com.example.avaliacaotecnicaleonardokruger.request.VoteRequest;
import com.example.avaliacaotecnicaleonardokruger.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pauta")
public class PrincipalController {

    private final SubjectService subjectService;

    @PostMapping(path ="/create")
    @ResponseStatus()
    public Mono<Subject> createSchedule(@RequestBody final SubjectRequest request) {
        return subjectService.createSubject(request);
    }

    @PostMapping(path ="/open")
    @ResponseStatus()
    public Mono<Subject> openSesson(@RequestBody final OpenSessonRequest request) {
        return subjectService.openSesson(request);
    }

    @PostMapping(path ="/vote")
    @ResponseStatus()
    public Mono<Vote> vote(@RequestBody final VoteRequest request) {
        return subjectService.vote(request);
    }

    @PostMapping(path ="/result")
    @ResponseStatus()
    public Mono<Result> vote(@RequestBody final ResultRequest request) {
        return subjectService.result(request);
    }

}
