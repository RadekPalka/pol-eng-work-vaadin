package com.example.route;

import com.example.Flashcard;
import com.example.QuizForm;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/waste")
public class Waste extends VerticalLayout {
    private final List<Flashcard> CARDS = List.of(
            new Flashcard("odpady ogólnie", List.of("waste")),
            new Flashcard("odpad produkcyjny / braki", List.of("scrap", "production scrap")),
            new Flashcard("odrzut (sztuki odrzucone)", List.of("rejected parts", "rejects")),
            new Flashcard("zanieczyszczenie", List.of("contamination")),
            new Flashcard("pył / drobinki z przemiału", List.of("dust", "fines")),
            new Flashcard("przemiał", List.of("regrind")),
            new Flashcard("mieszanka z przemiałem", List.of("blend with regrind"))
    );
    public Waste(){
        add(new H1("Odpady"));
        add(new QuizForm(CARDS));
        Anchor link = new Anchor(
                "https://radekpalka.github.io/factory-dictionary/waste-scrap-regrind.html",
                "Słownik słówek"
        );
        link.setTarget("_blank");
        add(link);

    }

    public List<Flashcard> getCards() {
        return CARDS;
    }
}
