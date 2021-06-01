package com.example.application.views;


import com.example.application.entity.Issue;
import com.example.application.service.IssueService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "add_Issue", layout = MainView.class)
@PageTitle("add Issue")
public class AddIssueView extends Div {

    private final TextField id = new TextField("ID");
    private final TextField typ = new TextField("Issue Typ");
    private final TextField name = new TextField("Issue Name");
    private final TextField description = new TextField("Description");
    private final NumberField minValue = new NumberField("min Value");
    private final NumberField maxValue = new NumberField("max Value");


    private final Button cancel = new Button("Cancel");
    private final Button add = new Button("add to Issue List");

    private final Binder<Issue> binder = new Binder<>(Issue.class);

    public AddIssueView(IssueService issueService) {
        addClassName("add-issue-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        add.addClickListener(e -> {
            issueService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " Issue stored.");
            clearForm();
        });
    }

    private void clearForm() {
        binder.setBean(new Issue());
    }

    private Component createTitle() {
        return new H3("add new Issue to Issue List");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(id, typ, name, description, minValue, maxValue);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        add.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(add);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
}
