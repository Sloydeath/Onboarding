package com.leverx.onboarding.streams.service.interfaces;

import com.leverx.onboarding.streams.model.*;

import java.util.List;


public interface PersonService {
    String findBestMatchingPerson(List<Person> people, Skill ... skills);
}
