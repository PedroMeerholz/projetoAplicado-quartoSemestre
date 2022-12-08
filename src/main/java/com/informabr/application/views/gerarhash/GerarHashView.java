package com.informabr.application.views.gerarhash;

import com.informabr.application.views.MainLayout;
import com.informabr.application.views.gerarhash.presenter.GerarHashPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Cadastro")
@Route(value = "/cadastro", layout = MainLayout.class)
@Uses(Icon.class)
public class GerarHashView extends VerticalLayout {
    private final GerarHashPresenter gerarHashPresenter;

    public GerarHashView(GerarHashPresenter gerarHashPresenter) {
        this.gerarHashPresenter = gerarHashPresenter;

        GerarHashForm gerarHashForm = new GerarHashForm();
        setSizeFull();
        setHorizontalComponentAlignment(Alignment.CENTER, gerarHashForm);
        setAlignItems(Alignment.CENTER);
        addClassName("gerar-hash-view");

        add(createTitle());
        add(gerarHashForm);

        gerarHashForm.getSave().addClickListener(event -> {

        });

        HashFormBinder binder = gerarHashPresenter.createBinder(gerarHashForm);
    }

    private Component createTitle() {
        return new H3("Realize seu cadastro para ter acesso aos endpoints da nossa API");
    }
}
