package ru.mirea;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatePresenter {

    @DateInject(value="dd:mm:ss") // day min sec
    private String date;

    @PostConstruct
    public void init() {
        System.out.println("date presenter run at" + date);
    }
}
