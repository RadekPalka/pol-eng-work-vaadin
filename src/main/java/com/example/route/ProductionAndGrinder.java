package com.example.route;

import com.example.Flashcard;
import com.example.QuizForm;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/production")
public class ProductionAndGrinder extends VerticalLayout {
    private final List<Flashcard> CARDS = List.of(
            new Flashcard("tworzywo", List.of("material", "plastic material")),
            new Flashcard("granulat", List.of("granulate", "pellets")),
            new Flashcard("regranulat", List.of("recycled material", "regranulate")),
            new Flashcard("przemiał", List.of("regrind", "regrind material")),
            new Flashcard("pierwotne tworzywo", List.of("virgin material")),
            new Flashcard("wtryskarka", List.of("injection molding machine", "injection machine")),
            new Flashcard("lej zasypowy", List.of("hopper")),
            new Flashcard("młynek", List.of("grinder")),
            new Flashcard("waga (urządzenie)", List.of("scale")),
            new Flashcard("waga / masa (materiału)", List.of("weight"))
    );
    public ProductionAndGrinder(){
        add(new H1("Produkcja i młynek"));
        add(new QuizForm(CARDS));
        Anchor link = new Anchor(
                "https://radekpalka.github.io/factory-dictionary/production-grinder.html",
                "Słownik słówek"
        );
        link.setTarget("_blank");
        add(link);
    }

    public List<Flashcard> getCards() {
        return CARDS;
    }
}
