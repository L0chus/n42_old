package com.example.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "Issue-List", layout = MainView.class)
@PageTitle("Issue List")
public class IssueListView extends Div {

    public IssueListView() {
        addClassName("issue-list-view");

    }

}
