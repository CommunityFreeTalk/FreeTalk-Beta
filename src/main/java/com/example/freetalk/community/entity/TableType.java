package com.example.freetalk.community.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TableType {

    POSTING("wr"), COMMENT("com");
    private final String tableName;



}
