package com.itaekit.gateway.service;

import com.itaekit.gateway.dto.project.request.CreateProjectRequestDto;
import com.itaekit.gateway.dto.project.response.CreateProjectResponseDto;

public interface TaskService {
    CreateProjectResponseDto registerProject(CreateProjectRequestDto requestDto);
}
