package com.example.freetalk.oauth2.dto;


import com.example.freetalk.oauth2.entity.Role;
import com.example.freetalk.oauth2.entity.User;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OAuthDto {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private  String registrationId;


    @Builder
    public OAuthDto(Map<String, Object> attributes,
                    String nameAttributeKey, String name,
                    String email, String registrationId) {
        this.attributes = attributes;
        this.nameAttributeKey= nameAttributeKey;
        this.name = name;
        this.email = email;
        this.registrationId = registrationId;
    }

    public static OAuthDto of(String registrationId,
                              String userNameAttributeName,
                              Map<String, Object> attributes) {

        if (registrationId.equals("facebook")) {
            return ofFacebook(userNameAttributeName, attributes);
        } else if (registrationId.equals("naver")) {
            return ofNaver("id", attributes);
        } else if (registrationId.equals("google")) {
            return ofGoogle(userNameAttributeName, attributes);
        }else if (registrationId.equals("kakao")) {
            return ofKakao(userNameAttributeName, attributes);
        }else {
            return null;
        }
    }

    private static OAuthDto ofGoogle(String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return OAuthDto.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthDto ofFacebook(String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return OAuthDto.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthDto ofNaver(String userNameAttributeName,
                                       Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        return OAuthDto.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    private static OAuthDto ofKakao(String userNameAttributeName,
                                     Map<String, Object> attributes) {
        Map<String,Object> response = (Map<String, Object>) attributes.get("kakao_account");
        Map<String,Object> profile = (Map<String, Object>) response.get("profile");
        return OAuthDto.builder()
                .name((String) profile.get("nickname"))
                .email((String) response.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.GUSET)
                .build();
    }
}