package com.itaekit.gateway.service.impl;

import com.itaekit.gateway.dto.account.request.CreateAccountRequestDto;
import com.itaekit.gateway.dto.account.request.EditAccountRequestDto;
import com.itaekit.gateway.dto.account.request.LoginAccountRequestDto;
import com.itaekit.gateway.dto.account.response.CreateAccountResponseDto;
import com.itaekit.gateway.dto.account.response.EditAccountResponseDto;
import com.itaekit.gateway.dto.account.response.LoginAccountResponseDto;
import com.itaekit.gateway.dto.user.UserDto;
import com.itaekit.gateway.exception.RegisterFailException;
import com.itaekit.gateway.exception.UserRequestFailException;
import com.itaekit.gateway.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateAccountServiceImpl implements AccountService {
    private final BCryptPasswordEncoder passwordEncoder;

    public RestTemplateAccountServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CreateAccountResponseDto registerUser(CreateAccountRequestDto requestDto) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070")
                .path("/api/account/register")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        ResponseEntity<CreateAccountResponseDto> responseDto = restTemplate.postForEntity(uri, requestDto, CreateAccountResponseDto.class);

        if (responseDto.getStatusCode().is2xxSuccessful()) {
            return responseDto.getBody();
        } else {
            throw new RegisterFailException("회원가입에 실패하였습니다.");
        }
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

    @Override
    public LoginAccountResponseDto findUserByUserId(LoginAccountRequestDto request) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070")
                .path("/api/login")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LoginAccountResponseDto> responseDto = restTemplate.postForEntity(uri, request, LoginAccountResponseDto.class);

        if (responseDto.getStatusCode().is2xxSuccessful()) {
            return responseDto.getBody();
        } else {
            throw new UserRequestFailException("로그인에 실패하였습니다.");
        }
    }

    @Override
    public UserDto getUserDetailsByUserId(String userId) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070")
                .path("/api/mypage/" + userId)
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> responseDto = restTemplate.getForEntity(uri, UserDto.class);

        if (responseDto.getStatusCode().is2xxSuccessful()) {
            return responseDto.getBody();
        } else {
            throw new UserRequestFailException("회원 정보 조회에 실패하였습니다.");
        }
    }
}
