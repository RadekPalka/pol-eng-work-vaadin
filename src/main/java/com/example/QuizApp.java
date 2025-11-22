package com.example;

import com.example.route.Materials;
import com.example.route.ProductionAndGrinder;
import com.example.route.WareHouse;
import com.example.route.Waste;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class QuizApp extends VerticalLayout {
    public QuizApp(){
        add(new H1("Quiz ze znajomości angielskiego w pracy"));
        add(new H2("Wybierz kategorię"));
        Nav nav = new Nav();
        OrderedList ul = new OrderedList();
        add(nav);
        nav.add(ul);
        ul.add(
                new ListItem(new RouterLink("Materiały i opakowania", Materials.class)),
                new ListItem(new RouterLink("Produkcja i młynek", ProductionAndGrinder.class)),
                new ListItem(new RouterLink("Magazyn i stanowiska", WareHouse.class)),
                new ListItem(new RouterLink("Odpady", Waste.class))
                );
        Anchor link = new Anchor(
                "https://radekpalka.github.io/factory-dictionary/",
                "Słownik słówek"
        );
        link.setTarget("_blank");
        add(link);
    }
}
