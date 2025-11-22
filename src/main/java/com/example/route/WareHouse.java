package com.example.route;

import com.example.Flashcard;
import com.example.QuizForm;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("/warehouse")
public class WareHouse extends VerticalLayout {
    private final List<Flashcard> CARDS = List.of(
            new Flashcard("wózkowy / operator wózka widłowego", List.of("forklift operator")),
            new Flashcard("wózek widłowy", List.of("forklift")),
            new Flashcard("ręczny paleciak", List.of("pallet jack")),
            new Flashcard("magazynier", List.of("warehouse worker")),
            new Flashcard("pracownik produkcji", List.of("production worker")),
            new Flashcard("kierownik", List.of("manager", "supervisor")),
            new Flashcard("kierownik zmiany", List.of("shift supervisor")),
            new Flashcard("brygadzista", List.of("foreman", "team leader")),
            new Flashcard("magazyn", List.of("warehouse")),
            new Flashcard("regał / stojak", List.of("shelf", "rack")),
            new Flashcard("miejsce paletowe", List.of("pallet space")),
            new Flashcard("strefa przyjęć", List.of("receiving area")),
            new Flashcard("strefa wysyłek", List.of("shipping area")),
            new Flashcard("załadunek", List.of("loading")),
            new Flashcard("rozładunek", List.of("unloading")),
            new Flashcard("rampa załadunkowa", List.of("loading ramp")),
            new Flashcard("nośnik (numer w systemie)", List.of("container ID"))
    );
    public WareHouse(){
        add(new H1("Magazyn i stanowiska"));
        add(new QuizForm(CARDS));
        Anchor link = new Anchor(
                "https://radekpalka.github.io/factory-dictionary/warehouse-roles.html",
                "Słownik słówek"
        );
        link.setTarget("_blank");
        add(link);
    }

    public List<Flashcard> getCards() {
        return CARDS;
    }
}
