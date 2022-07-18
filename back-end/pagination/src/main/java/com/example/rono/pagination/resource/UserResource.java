package com.example.rono.pagination.resource;

import com.example.rono.pagination.domain.HttpResponse;
import com.example.rono.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<HttpResponse>getUsers(@RequestParam Optional<String> name,
                                                @RequestParam Optional<Integer> page,
                                                @RequestParam Optional<Integer> size) throws InterruptedException{
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("page", userService.getUser(name.orElse(""), page.orElse(0), size.orElse(10))))
                        .message("Users Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }
}
