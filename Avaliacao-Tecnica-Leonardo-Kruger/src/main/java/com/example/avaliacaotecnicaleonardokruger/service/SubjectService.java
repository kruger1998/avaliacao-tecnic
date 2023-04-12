package com.example.avaliacaotecnicaleonardokruger.service;

import com.example.avaliacaotecnicaleonardokruger.dto.Result;
import com.example.avaliacaotecnicaleonardokruger.dto.Session;
import com.example.avaliacaotecnicaleonardokruger.dto.Subject;
import com.example.avaliacaotecnicaleonardokruger.dto.Vote;
import com.example.avaliacaotecnicaleonardokruger.enumeration.VoteEnum;
import com.example.avaliacaotecnicaleonardokruger.repository.SubjectRepository;
import com.example.avaliacaotecnicaleonardokruger.repository.VoteRepository;
import com.example.avaliacaotecnicaleonardokruger.request.OpenSessonRequest;
import com.example.avaliacaotecnicaleonardokruger.request.ResultRequest;
import com.example.avaliacaotecnicaleonardokruger.request.SubjectRequest;
import com.example.avaliacaotecnicaleonardokruger.request.VoteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    private final VoteRepository voteRepository;

    public Mono<Subject> createSubject(SubjectRequest request) {
        return subjectRepository.save(Subject.builder()
                .name(request.getName())
                .description(request.getDescription())
                .session(Session.builder().open(Boolean.FALSE).build())
                .build());
    }

    public Mono<Subject> openSesson(OpenSessonRequest request) {
        Session startSession = getSessionValues(request);

        return subjectRepository.findSubjectById(request.getSubjectId())
                .map(subject -> {
                    subject.setSession(startSession);
                    return subject;
                })
                .flatMap(subjectRepository::save);
    }

    public Mono<Vote> vote(VoteRequest request) {
        return subjectRepository.findSubjectById(request.getSubjectId())
                .filter(subject -> sessionStillOpen(subject.getSession()))
                .filter(subject -> Boolean.FALSE.equals(voteRepository.existsByAssociateIdAndSubjectId(request.getAssociateId(), request.getSubjectId()).block()))
                .flatMap(subject -> voteRepository.save(Vote.builder()
                        .associateId(request.getAssociateId())
                        .subjectId(request.getSubjectId())
                        .voteEnum(request.getVoteEnum())
                        .build()));
    }

    public Mono<Result> result(ResultRequest request) {
        return voteRepository.findAllBySubjectId(request.getSubjectId())
                .map(this::calculateResult);
    }

    private Session getSessionValues(OpenSessonRequest request) {
        LocalDateTime sessionEndTime = ObjectUtils.isEmpty(request.getEndTime()) ?
                LocalDateTime.now().plusMinutes(1L) :
                request.getEndTime();

        return Session.builder()
                .open(Boolean.FALSE)
                .endTime(sessionEndTime)
                .build();
    }

    private Boolean sessionStillOpen(Session session) {
        return session.getEndTime().isBefore(LocalDateTime.now());
    }

    private Result calculateResult(List<Vote> votes) {
        long yesVotes = votes.stream().filter(vote -> vote.getVoteEnum().equals(VoteEnum.SIM)).count();
        long noVotes = votes.stream().filter(vote -> vote.getVoteEnum().equals(VoteEnum.NAO)).count();

        return Result.builder()
                .yesVotes(yesVotes)
                .noVotes(noVotes)
                .build();
    }

}
