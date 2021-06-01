package com.example.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "Improvment-Backlog", layout = MainView.class)
@PageTitle("Improvment Backlog")
public class ImprovmentBacklogView extends Div {

    public ImprovmentBacklogView() {
        addClassName("improvment-backlog-view");

    }

}
