package com.entrevista.domain.service;

import com.entrevista.api.model.input.ReleaseMapper;
import com.entrevista.domain.model.Person;
import com.entrevista.domain.model.Release;
import com.entrevista.domain.repository.PersonRepository;
import com.entrevista.domain.repository.ReleaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InjectReleasesService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public ReleaseMapper injectValue(ReleaseMapper releaseInput) {

        Person person = personRepository.getById(releaseInput.getPerson().getId());
        Release release = modelMapper.map(releaseInput, Release.class);
        release.setPerson(person);

        return modelMapper.map(releaseRepository.save(release)
                , ReleaseMapper.class);
    }
}
