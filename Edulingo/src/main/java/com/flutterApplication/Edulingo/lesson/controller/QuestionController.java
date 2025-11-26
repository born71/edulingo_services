package com.flutterApplication.Edulingo.lesson.controller;

import com.flutterApplication.Edulingo.lesson.entity.Lesson;
import com.flutterApplication.Edulingo.lesson.entity.Question;
import com.flutterApplication.Edulingo.lesson.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")   // ให้ตรงกับ AppConfig.effectiveApiUrl = .../api
@CrossOrigin(origins = "*")  // ชั่วคราวสำหรับ dev (Flutter web / mobile)
public class QuestionController {

    private final LessonService lessonService;

    public QuestionController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // GET /api/questions
    @GetMapping("/questions")
    public List<Question> getAllQuestion() {
        return lessonService.getAllQuestion();
    }

}
