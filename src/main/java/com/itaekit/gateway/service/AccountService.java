package com.itaekit.gateway.service;

import com.itaekit.gateway.dto.account.request.EditAccountRequestDto;
import com.itaekit.gateway.dto.account.response.CreateAccountResponseDto;
import com.itaekit.gateway.dto.account.response.EditAccountResponseDto;

public interface AccountService {
    CreateAccountResponseDto registerUser(CreateAccountResponseDto requestDto);
    EditAccountResponseDto editUser(EditAccountRequestDto requestDto);
//    int removeUser(String userId);
}
