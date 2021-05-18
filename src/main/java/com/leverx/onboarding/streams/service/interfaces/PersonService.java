package com.leverx.onboarding.streams.service.interfaces;

import com.leverx.onboarding.streams.model.*;

import java.util.*;

public interface PersonService {
    String findBestMatchingPerson(List<Person> persons, Skill ... skills);
}
