package com.itaekit.gateway.controller;

import com.itaekit.gateway.dto.project.request.CreateProjectRequestDto;
import com.itaekit.gateway.dto.project.response.CreateProjectResponseDto;
import com.itaekit.gateway.dto.user.UserDto;
import com.itaekit.gateway.service.AccountService;
import com.itaekit.gateway.service.TaskService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class TaskController {
    private final TaskService taskService;
    private final AccountService accountService;

    @GetMapping("/project/register")
    public String registerProject(HttpSession session, Model model) {
        UserDto userDto = accountService.getUserDetailsByUserId(session.getAttribute("userId").toString());
        model.addAttribute("user", userDto);
        return "projectRegisterForm";
    }

    @PostMapping("/project/register")
    public String doRegisterProject(CreateProjectRequestDto requestDto) {
        CreateProjectResponseDto responseDto = taskService.registerProject(requestDto);
        return "redirect:/";
    }

}
