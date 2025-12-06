package com.flutterApplication.Edulingo.lesson.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    private Lesson lesson;

    @com.fasterxml.jackson.annotation.JsonProperty("lessonId")
    public String getLessonId() {
        return lesson != null ? lesson.getId() : null;
    }

    @Column(columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String options;   // JSON string

    @Column(length = 30)
    private String type;      // multipleChoice, fillInBlank, ...

    @Column(length = 20)
    private String difficulty;

    @Column(length = 50)
    private String language;

    @Column(name = "audio_url", length = 500)
    private String audioUrl;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column(name = "order_index")
    private Integer orderIndex = 0;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();


}
