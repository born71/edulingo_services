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
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(length = 36)
    private String id;   // ใช้ UUID string ก็ได้

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 50)
    private String language;

    @Column(length = 20)
    private String difficulty; // 'beginner', 'intermediate', 'advanced'

    @Column(name = "estimated_minutes")
    private Integer estimatedMinutes;

    // เก็บ topics เป็น JSON string ไปก่อน
    @Column(columnDefinition = "TEXT")
    private String topics;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();


}
