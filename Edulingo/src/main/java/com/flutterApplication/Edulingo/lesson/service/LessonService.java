package com.flutterApplication.Edulingo.lesson.service;

import com.flutterApplication.Edulingo.lesson.entity.Lesson;
import com.flutterApplication.Edulingo.lesson.entity.Question;
import com.flutterApplication.Edulingo.lesson.repository.LessonRepository;
import com.flutterApplication.Edulingo.lesson.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;

    public LessonService(LessonRepository lessonRepository, QuestionRepository questionRepository) {
        this.lessonRepository = lessonRepository;
        this.questionRepository = questionRepository;
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson getLessonById(String id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }

    public List<Question> getQuestionsForLesson(String lessonId) {
        return questionRepository.findByLessonIdOrderByOrderIndexAsc(lessonId);
    }

    public List<Lesson> searchLessons(String query) {
        return lessonRepository.findByTitleContainingIgnoreCase(query);
    }

    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }

    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }
}
