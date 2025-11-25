package com.flutterApplication.Edulingo.lesson.repository;

import com.flutterApplication.Edulingo.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, String> {

    List<Lesson> findByLanguageAndIsActiveTrue(String language);

    List<Lesson> findByTitleContainingIgnoreCase(String title);
}
