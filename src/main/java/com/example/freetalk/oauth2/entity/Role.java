package com.example.freetalk.oauth2.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUSET("ROLE_GUEST", "손님"),
    PAUSED("ROLE_PAUSED", "일시정지 사용자"),
    BANNED("ROLE_BANNED", "정지 사용자"),
    ADMIN("ROLE_ADMIN", "관리자"),
    USER("ROLE_USER", "일반 사용자");


    private final String key;
    private final String title;
}