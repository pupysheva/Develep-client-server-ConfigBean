package ru.mirea;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@MethodTimer
public class DatePresenterImpl implements DatePresenter {

    @DateInject(format = "hh:mm:ss") // day min sec
    private String date;

    @DateInject(format = "yyy-MM-dd hh:mm:ss") // day min sec
    private String fullDate;

    @PostConstruct
    public void init() {
        System.out.println("date presenter run at" + date);
    }

    public void present() {
        System.out.println("Current date: " + fullDate);
    }
}
