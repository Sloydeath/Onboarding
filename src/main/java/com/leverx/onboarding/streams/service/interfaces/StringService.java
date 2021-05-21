package com.leverx.onboarding.streams.service.interfaces;


import java.util.Map;

public interface StringService {
    Map.Entry<Character, Long> getMostCommonChar(String str);
}
