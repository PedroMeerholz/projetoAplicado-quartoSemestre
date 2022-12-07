package com.informabr.application.views.gerarhash.presenter;

import com.informabr.api.service.UserService;
import com.informabr.application.views.gerarhash.GerarHashForm;
import com.informabr.application.views.gerarhash.HashFormBinder;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class GerarHashPresenter {
    private final UserService userService;
    private HashFormBinder hashFormBinder;

    public GerarHashPresenter(UserService userService) {
        this.userService = userService;
    }

    public HashFormBinder createBinder(GerarHashForm gerarHashForm) {
        hashFormBinder = new HashFormBinder(gerarHashForm, userService);
        hashFormBinder.addBindingAndValidation();
        return this.hashFormBinder;
    }
}
