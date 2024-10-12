package com.itaekit.gateway.service.impl;

import com.itaekit.gateway.dto.account.request.EditAccountRequestDto;
import com.itaekit.gateway.dto.account.response.CreateAccountResponseDto;
import com.itaekit.gateway.dto.account.response.EditAccountResponseDto;
import com.itaekit.gateway.service.AccountService;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateAccountServiceImpl implements AccountService {
    @Override
    public CreateAccountResponseDto registerUser(CreateAccountResponseDto requestDto) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070")
                .path("/api/account/register")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        return null;
    }

    @Override
    public EditAccountResponseDto editUser(EditAccountRequestDto requestDto) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070")
                .path("/api/account/register")
                .encode()
                .build()
                .toUri();

        return null;
    }
}
