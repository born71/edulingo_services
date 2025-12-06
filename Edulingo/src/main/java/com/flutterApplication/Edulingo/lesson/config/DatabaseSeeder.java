package com.flutterApplication.Edulingo.lesson.config;

import com.flutterApplication.Edulingo.lesson.entity.Lesson;
import com.flutterApplication.Edulingo.lesson.entity.Question;
import com.flutterApplication.Edulingo.lesson.repository.LessonRepository;
import com.flutterApplication.Edulingo.lesson.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;

    public DatabaseSeeder(LessonRepository lessonRepository,
                          QuestionRepository questionRepository) {
        this.lessonRepository = lessonRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // กันไว้: ถ้าเคยมีข้อมูลแล้ว จะไม่ seed ซ้ำ
        if (lessonRepository.count() > 0) {
            return;
        }

        seedBasicGreetings();
        seedSpanishNumbers();
        // TODO: เพิ่ม method seed อื่น ๆ: seedFrenchColors(), seedGermanFamily(), ...
    }

    private void seedBasicGreetings() {
        Lesson lesson = new Lesson();
        lesson.setId("basic_greetings");
        lesson.setTitle("Basic Greetings");
        lesson.setDescription("Learn essential greetings in different languages");
        lesson.setLanguage("Multiple");
        lesson.setDifficulty("beginner");
        lesson.setEstimatedMinutes(12);
        lesson.setTopics(json(List.of("greetings", "basics", "conversation")));

        lessonRepository.save(lesson);

        Question q1 = new Question();
        q1.setId("greeting_1");
        q1.setLesson(lesson);
        q1.setOrderIndex(1);
        q1.setQuestion("Select the Spanish word for \"Hello\"");
        q1.setCorrectAnswer("Hola");
        q1.setOptions(json(List.of("Guten Tag", "Bonjour", "Hola", "Ciao")));
        q1.setLanguage("Spanish");
        q1.setDifficulty("beginner");
        q1.setExplanation("Hola is the most common and friendly way to say hello in Spanish.");

        Question q2 = new Question();
        q2.setId("greeting_2");
        q2.setLesson(lesson);
        q2.setOrderIndex(2);
        q2.setQuestion("How do you say \"Thank you\" in French?");
        q2.setCorrectAnswer("Merci");
        q2.setOptions(json(List.of("Danke", "Merci", "Gracias", "Arigato")));
        q2.setLanguage("French");
        q2.setDifficulty("beginner");
        q2.setExplanation("Merci is the standard way to say thank you in French.");

        Question q3 = new Question();
        q3.setId("greeting_3");
        q3.setLesson(lesson);
        q3.setOrderIndex(3);
        q3.setQuestion("What is the German word for \"Water\"?");
        q3.setCorrectAnswer("Wasser");
        q3.setOptions(json(List.of("Agua", "Eau", "Wasser", "Mizu")));
        q3.setLanguage("German");
        q3.setDifficulty("beginner");
        q3.setExplanation("Wasser is the German word for water, pronounced \"VAH-ser\".");

        Question q4 = new Question();
        q4.setId("greeting_4");
        q4.setLesson(lesson);
        q4.setOrderIndex(4);
        q4.setQuestion("How do you say \"Good morning\" in Spanish?");
        q4.setCorrectAnswer("Buenos días");
        q4.setOptions(json(List.of("Buenas noches", "Buenos días", "Buenas tardes", "Hasta luego")));
        q4.setLanguage("Spanish");
        q4.setDifficulty("beginner");
        q4.setExplanation("Buenos días means \"good morning\" in Spanish, used until noon.");

        Question q5 = new Question();
        q5.setId("greeting_5");
        q5.setLesson(lesson);
        q5.setOrderIndex(5);
        q5.setQuestion("What does \"Au revoir\" mean in French?");
        q5.setCorrectAnswer("Goodbye");
        q5.setOptions(json(List.of("Hello", "Thank you", "Goodbye", "Please")));
        q5.setLanguage("French");
        q5.setDifficulty("beginner");
        q5.setExplanation("Au revoir is a formal way to say goodbye in French.");

        questionRepository.saveAll(List.of(q1, q2, q3, q4, q5));
    }

    private void seedSpanishNumbers() {
        Lesson lesson = new Lesson();
        lesson.setId("spanish_numbers_1_10");
        lesson.setTitle("Spanish Numbers 1-10");
        lesson.setDescription("Master counting from 1 to 10 in Spanish");
        lesson.setLanguage("Spanish");
        lesson.setDifficulty("beginner");
        lesson.setEstimatedMinutes(15);
        lesson.setTopics(json(List.of("numbers", "counting", "mathematics")));

        lessonRepository.save(lesson);

        Question q1 = new Question();
        q1.setId("number_1");
        q1.setLesson(lesson);
        q1.setOrderIndex(1);
        q1.setQuestion("How do you say \"One\" in Spanish?");
        q1.setCorrectAnswer("Uno");
        q1.setOptions(json(List.of("Dos", "Uno", "Tres", "Cuatro")));
        q1.setLanguage("Spanish");
        q1.setDifficulty("beginner");
        q1.setExplanation("Uno is \"one\" in Spanish, pronounced \"OO-no\".");

        Question q2 = new Question();
        q2.setId("number_2");
        q2.setLesson(lesson);
        q2.setOrderIndex(2);
        q2.setQuestion("What is \"Five\" in Spanish?");
        q2.setCorrectAnswer("Cinco");
        q2.setOptions(json(List.of("Cuatro", "Cinco", "Seis", "Siete")));
        q2.setLanguage("Spanish");
        q2.setDifficulty("beginner");
        q2.setExplanation("Cinco means \"five\" in Spanish, pronounced \"SEEN-ko\".");

        Question q3 = new Question();
        q3.setId("number_3");
        q3.setLesson(lesson);
        q3.setOrderIndex(3);
        q3.setQuestion("How do you say \"Ten\" in Spanish?");
        q3.setCorrectAnswer("Diez");
        q3.setOptions(json(List.of("Nueve", "Ocho", "Diez", "Once")));
        q3.setLanguage("Spanish");
        q3.setDifficulty("beginner");
        q3.setExplanation("Diez means \"ten\" in Spanish, pronounced \"dee-ESS\".");

        Question q4 = new Question();
        q4.setId("number_4");
        q4.setLesson(lesson);
        q4.setOrderIndex(4);
        q4.setQuestion("What number is \"Siete\"?");
        q4.setCorrectAnswer("Seven");
        q4.setOptions(json(List.of("Six", "Seven", "Eight", "Nine")));
        q4.setLanguage("Spanish");
        q4.setDifficulty("beginner");
        q4.setExplanation("Siete means \"seven\" in Spanish.");

        Question q5 = new Question();
        q5.setId("number_5");
        q5.setLesson(lesson);
        q5.setOrderIndex(5);
        q5.setQuestion("Which number comes after \"Tres\"?");
        q5.setCorrectAnswer("Cuatro");
        q5.setOptions(json(List.of("Dos", "Cuatro", "Cinco", "Seis")));
        q5.setLanguage("Spanish");
        q5.setDifficulty("beginner");
        q5.setExplanation("After tres (three) comes cuatro (four).");

        questionRepository.saveAll(List.of(q1, q2, q3, q4, q5));
    }

    // helper แปลง List<String> -> JSON string (แบบง่าย)
    private String json(List<String> list) {
        return "[\"" + String.join("\",\"", list) + "\"]";
    }
}
