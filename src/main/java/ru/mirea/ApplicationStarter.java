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

    @PostConstruct
    public void init() {
        datePresenter.present();
    }
}
