package com.example.application.views;

import com.example.application.service.SolutionService;
import com.example.application.entity.Solution;
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

@Route(value = "add_Solution", layout = MainView.class)
@PageTitle("add Solution")
public class AddSolutionView extends Div {

    private final TextField id = new TextField("Solution ID");
    private final TextField name = new TextField("Solution Name");
    private final TextField description = new TextField("Description");
    private final NumberField minCost = new NumberField("min Cost");
    private final NumberField maxCost = new NumberField("max Cost");

    private final Button cancel = new Button("Cancel");
    private final Button addS = new Button("add to Improvement Backlog");

    private final Binder<Solution> binder = new Binder<>(Solution.class);

    public AddSolutionView(SolutionService solutionService) {
        addClassName("add-solution-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        addS.addClickListener(e -> {
            solutionService.update(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
        });
    }

    private void clearForm() {
        binder.setBean(new Solution());
    }

    private Component createTitle() {
        return new H3("add new Solution to Improvement Backlog");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(id, name, description, description, minCost, maxCost);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        addS.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(addS);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
}
