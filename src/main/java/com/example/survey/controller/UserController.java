package com.example.survey.controller;

import com.example.survey.domain.User;
import com.example.survey.repo.RoleRepo;
import com.example.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private RoleRepo roleRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", roleRepository.findAll().stream().map(x->x.getName()).collect(Collectors.toList()));
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam Map<String, String> form, @RequestParam("userID") User user){
        userService.saveUser(user, username, form);
        return "redirect:/user";
    }
}


