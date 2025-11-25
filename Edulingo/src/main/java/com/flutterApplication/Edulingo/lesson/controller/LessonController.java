package com.flutterApplication.Edulingo.lesson.controller;

import com.flutterApplication.Edulingo.lesson.entity.Lesson;
import com.flutterApplication.Edulingo.lesson.entity.Question;
import com.flutterApplication.Edulingo.lesson.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")   // ให้ตรงกับ AppConfig.effectiveApiUrl = .../api
@CrossOrigin(origins = "*")  // ชั่วคราวสำหรับ dev (Flutter web / mobile)
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // GET /api/lessons
    @GetMapping("/lessons")
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    // GET /api/lessons/{id}
    @GetMapping("/lessons/{id}")
    public Lesson getLessonById(@PathVariable String id) {
        return lessonService.getLessonById(id);
    }

    // GET /api/lessons/{id}/questions
    @GetMapping("/lessons/{id}/questions")
    public List<Question> getLessonQuestions(@PathVariable String id) {
        return lessonService.getQuestionsForLesson(id);
    }

    // GET /api/lessons/search?query=xxx
    @GetMapping("/lessons/search")
    public List<Lesson> searchLessons(@RequestParam String query) {
        return lessonService.searchLessons(query);
    }

    // (optional) POST /api/lessons  สำหรับ admin / backend CMS
    @PostMapping("/lessons")
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }

    // (optional) DELETE /api/lessons/{id}
    @DeleteMapping("/lessons/{id}")
    public void deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
    }
}
