package ru.mirea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationStarter {

    private DatePresenter datePresenter;

    @Autowired
    public ApplicationStarter(DatePresenter dp) {
        this.datePresenter = dp;
    }

    @DateInject(format = "hh:mm:ss")
    private String date;

    @PostConstruct
    public void init() {
        System.out.printf("Application start at: %s\n", date);
        datePresenter.present();
    }
}
