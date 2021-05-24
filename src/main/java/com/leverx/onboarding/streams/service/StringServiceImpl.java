package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.service.interfaces.StringService;


import java.util.Map;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StringServiceImpl implements StringService {
    @Override
    public Map.Entry<Character, Long> getMostCommonChar(String str) {
        return str.chars()
                .mapToObj(character -> (char)character)
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .max(comparingByValue())
                .orElse(null);
    }
}
