package org.marathon.code.competition.controller;

import org.apache.log4j.Logger;
import org.marathon.code.competition.domain.User;
import org.marathon.code.competition.repository.UserRepository;
import org.marathon.code.competition.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/users")
@Controller
public class UserAPIController {

    public static final Logger logger = Logger.getLogger(UserAPIController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public String accounts(Model model, @PageableDefaults(value = 20, pageNumber = 0) Pageable pageable) {
        model.addAttribute("users", userRepository.findAll(pageable));
        return "user/users";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> usersJSON(@PageableDefaults(value = 20, pageNumber = 0) Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        String usersJson = JsonUtil.getGson().toJson(users);
        return createPlainResponseEntity(usersJson);
    }

    @RequestMapping(value = "/{userId}/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> userJSON(@PathVariable("userId") Long userId) {
        User user = userRepository.findOne(userId);
        String usersJson = JsonUtil.getGson().toJson(user);
        return createPlainResponseEntity(usersJson);
    }

    private ResponseEntity<String> createPlainResponseEntity(String response) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/text; charset=utf-8");
        return new ResponseEntity<String>(response, headers, HttpStatus.OK);
    }
}
