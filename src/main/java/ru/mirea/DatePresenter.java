package ru.mirea;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatePresenter {

    @DateInject(format = "dd:mm:ss") // day min sec
    private String date;

    @DateInject(format = "yyy-MM-dd dd:mm:ss") // day min sec
    private String fullDate;

    @PostConstruct
    public void init() {
        System.out.println("date presenter run at" + date);
    }

    public void present() {
        System.out.println("Current date: " + fullDate);
    }
}
