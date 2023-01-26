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

        if( registrationId.equals("kakao") ){
            return ofFacebook( registrationId , userNameAttributeName, attributes);
        } else if (registrationId.equals("naver") ) {
            return ofNaver( registrationId , userNameAttributeName, attributes);
        } else if ( registrationId.equals("google") ) {
            return ofGoogle( registrationId , userNameAttributeName, attributes);
        }else {
            return null;
        }
    }

    private static OAuthDto ofGoogle(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return OAuthDto.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .registrationId(registrationId)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthDto ofFacebook(String registrationId, String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return OAuthDto.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .registrationId(registrationId)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthDto ofNaver(String registrationId, String userNameAttributeName,
                                       Map<String, Object> attributes) {
        return OAuthDto.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .registrationId(registrationId)
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