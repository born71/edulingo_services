package com.flutterApplication.Edulingo.lesson.repository;

import com.flutterApplication.Edulingo.lesson.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, String> {

    List<Question> findByLessonIdOrderByOrderIndexAsc(String lessonId);
}
