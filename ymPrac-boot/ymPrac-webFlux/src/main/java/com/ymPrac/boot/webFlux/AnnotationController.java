package com.ymPrac.boot.webFlux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Yan Meng
 * @date 2018/8/6.
 */
@RestController
public class AnnotationController {

    @GetMapping("/annotation")
    public Mono<String> annotation() {
        return Mono.just("helloo, annotation controller!");
    }
}
