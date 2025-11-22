package com.example.route;

import com.example.Flashcard;
import com.example.QuizForm;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/materials")
public class Materials extends VerticalLayout {
    private final List<Flashcard> CARDS = List.of(
            new Flashcard("paleta", List.of("pallet")),
            new Flashcard("duży karton", List.of("big box", "large carton")),
            new Flashcard("mały karton", List.of("small box", "small carton")),
            new Flashcard("karton zbiorczy", List.of("master carton")),
            new Flashcard("taśma klejąca", List.of("adhesive tape", "sticky tape")),
            new Flashcard("taśma pakowa", List.of("packing tape")),
            new Flashcard("folia stretch", List.of("stretch film", "stretch wrap")),
            new Flashcard("worek", List.of("bag")),
            new Flashcard("worek big-bag", List.of("big bag", "bulk bag")),
            new Flashcard("oktabina", List.of("octabin", "octabin box"))
    );
    public Materials(){
        add(new H1("Materiały"));
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
