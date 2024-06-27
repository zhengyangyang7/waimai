package com.example.elm.util;

import java.util.Base64;

public class Base64Util {

    // 编码
    public static String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // 解码
    public static String decode(String base64Data) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
        return new String(decodedBytes);
    }
}
