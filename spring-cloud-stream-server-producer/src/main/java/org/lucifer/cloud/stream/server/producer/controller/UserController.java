package org.lucifer.cloud.stream.server.producer.controller;

import com.beyond.result.Result;
import org.lucifer.cloud.stream.common.model.User;
import org.lucifer.cloud.stream.server.producer.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucifer
 * @since 2023/10/19
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Result<Object> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return Result.ok();
    }

}
