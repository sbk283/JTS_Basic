package com.std.sbb.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList () {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
         Optional<Question> oq = this.questionRepository.findById(id);
        if (!oq.isPresent()) throw new RuntimeException();
        return oq.get();
    }

    public Question create(String subject, String content) {
            Question q = new Question();
            q.setSubject(subject);
            q.setContent(content);
            q.setCreateDate(LocalDateTime.now());
            this.questionRepository.save(q);
            return q;
    }
}
