package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Language;

import java.util.List;

public interface LanguageService {
    List<Language> listAll();

    void saveOrUpdateLanguage(Language language);

    void deleteLanguage(Language language);

    Language findById(Integer id);
}
