package com.informabr.application;

import com.informabr.api.entity.User;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Theme(value = "informabr")
@PWA(name = "InformaBR", shortName = "InformaBR", offlineResources = {})
@EntityScan(basePackageClasses = {Application.class, User.class})
@NpmPackage(value = "line-awesome", version = "1.3.0")
@NpmPackage(value = "@vaadin-component-factory/vcf-nav", version = "1.0.6")
@ComponentScan(basePackages = {"com.informabr.api.controller", "com.informabr.api.repository", "com.informabr.api.service", "com.informabr.api.utils.generator", "com.informabr.api.utils"})
@ComponentScan("com.informabr.application.views.gerarhash")
@EnableJpaRepositories("com.informabr.api.repository")
@EnableSwagger2
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
