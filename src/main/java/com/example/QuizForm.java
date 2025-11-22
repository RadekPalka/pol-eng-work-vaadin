package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.RouterLink;

import java.util.*;

enum AppState {
    CHECK_ANSWER,
    SHOW_NEXT_WORD,
    END
}

public class QuizForm extends VerticalLayout {
    private final List<Flashcard> flashcards = new ArrayList<>();
    private final H2 wordToTranslate = new H2();
    private final TextField answerField = new TextField("Odpowiedź po angielsku");
    private final Paragraph feedback = new Paragraph();
    private final Paragraph wordsLeft = new Paragraph();
    private final Button button = new Button("Sprawdź");
    private int index = 0;
    private AppState currentAction = AppState.CHECK_ANSWER;
    private int correctAnswers =0;
    private int badAnswers = 0;
    private final Set<Flashcard> flashcardsToLearn = new HashSet<>();

    public QuizForm(List<Flashcard> flashcards){
        add(wordsLeft, wordToTranslate, answerField, feedback, button);
        this.flashcards.addAll(flashcards);
        Collections.shuffle(this.flashcards);
        button.addClickListener(e-> handleButton());
        wordToTranslate.setText(this.flashcards.get(index).getPolishWorld());
        wordsLeft.setText("Ilość fiszek do odgadnięcia: " + flashcards.size());
    }

    private void handleButton(){
        if (currentAction == AppState.CHECK_ANSWER){
            button.setText("Następny wyraz");
            checkAnswer();
            if (currentAction == AppState.END) {
                showEndingMessage();
                return;
            }
            currentAction = AppState.SHOW_NEXT_WORD;
            manageIndex();
        } else if (currentAction == AppState.SHOW_NEXT_WORD) {
            button.setText("Sprawdź");
            currentAction = AppState.CHECK_ANSWER;
            wordToTranslate.setText(flashcards.get(index).getPolishWorld());
            answerField.clear();
            feedback.setText("");
        }


    }

    private void checkAnswer(){
        List<String> englishWords = flashcards.get(index).getEnglishWords();
        String userAnswer = answerField.getValue().trim();

        boolean correct = englishWords.stream()
                .anyMatch(ans -> ans.equalsIgnoreCase(userAnswer));
        if (correct){
            feedback.setText("Prawidłowa odpowiedź");
            flashcards.remove(index);
            wordsLeft.setText("Ilość fiszek do odgadnięcia: " + flashcards.size());
            increaseCorrectAnswers();
        }
        else{
            showBadAnswerMessage(englishWords);
            increaseBadAnswers();
            flashcardsToLearn.add(flashcards.get(index));
        }
    }

    private void showBadAnswerMessage(List<String> englishWords){
        if (englishWords.size() == 1){
            feedback.getElement().setProperty(
                    "innerHTML",
                    "Zła odpowiedź. Prawidłowa odpowiedź to <strong>" + englishWords.getFirst() + "</strong>"
            );
            return;
        }
        feedback.getElement().setProperty(
                "innerHTML",
                "Zła odpowiedź. Prawidłowe odpowiedzi to: <strong>"
                        + String.join(", ", englishWords)
                        + "</strong>"
        );

    }

    private void manageIndex(){
        if (flashcards.isEmpty()){
            currentAction = AppState.END;
            return;
        }
        if (index < flashcards.size() -1){
            index ++;
            return;
        }
        index = 0;
    }

    private void showEndingMessage(){
        removeAll();
        add(new H2("Koniec Quizu"), new RouterLink("Wróć do strony głównej", QuizApp.class));
        add(new Paragraph("Liczba poprawnych odpowiedzi to: " + correctAnswers));
        add(new Paragraph("Liczba złych odpowiedzi to " + badAnswers));
        if (badAnswers == 0){
            add(new Paragraph("Gratulacje. Ukończyłeś quiz bezbłędnie"));
            return;
        }
        add(new Paragraph("Gratulacje. Ukończyłeś quiz. Jednak popełniłeś kilka błędów. Oto fiszki do powtórzenia"));
        OrderedList orderedList = new OrderedList();
        add(orderedList);
        for (Flashcard flashcard : flashcardsToLearn){
            String polish = flashcard.getPolishWorld();
            String englishJoined = String.join(", ", flashcard.getEnglishWords());

            ListItem li = new ListItem();
            li.getElement().setProperty(
                    "innerHTML",
                    polish + " → <strong>" + englishJoined + "</strong>"
            );
            orderedList.add(li);
        }
    }

    public void increaseCorrectAnswers() {
        correctAnswers ++;
    }

    public void increaseBadAnswers() {
        badAnswers ++;
    }

}
