package br.com.mnader.rocketseat_desafio1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class DevelopmentMain implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
    }
}
