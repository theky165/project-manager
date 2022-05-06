package com.example.projectsmanagement.service;

import com.example.projectsmanagement.entities.Language;
import com.example.projectsmanagement.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Language> listAll() {
        return languageRepository.findAll();
    }

    @Override
    public void saveOrUpdateLanguage(Language language) {
        languageRepository.save(language);
    }

    @Override
    public void deleteLanguage(Language language) {
        languageRepository.deleteById(language.getId());
    }

    @Override
    public Language findById(Integer id) {
            Optional<Language> projectOptional = languageRepository.findById(id);
            if (!projectOptional.isPresent()) {
                return new Language();
            }
            return projectOptional.get();
    }
}
