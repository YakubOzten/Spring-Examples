package com.yakubozten.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  //  Logger logger = LoggerFactory.getLogger(this.getClass());
@RestController
@RequestMapping("/log")
public class LogEndpoint {


    @GetMapping
    public String getDetails() {

        log.info("get details methodu basladi.");
        return internalLogDetail();
    }

    private String internalLogDetail() {
        try {
            log.debug("internalLogDetail methodu basladi.");
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (Exception e) {
            log.error("Hata : {}", e);
        }
        return "";
    }
}
   /*
   loglama asekron olmalıdır
   printStackTrace ve System.out.println() kullanılmamalıdır. (format)
   sensitive data olmamalıdır.
   tüm loglar merkezi toplanmalidir.belli formatta
   Level dikkatli kullanılmalıdır.
   Farklı levellar için farklı appendarlar kullanabilir.

    */



