package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.service.interfaces.StringService;

import java.util.Map.*;

import static java.util.Map.Entry.*;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

public class StringServiceImpl implements StringService {
    @Override
    public Entry<Character, Long> getMostCommonChar(String str) {
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
