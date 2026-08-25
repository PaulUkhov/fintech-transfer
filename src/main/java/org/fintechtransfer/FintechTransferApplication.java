package org.fintechtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FintechTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(FintechTransferApplication.class, args);
    }

}
