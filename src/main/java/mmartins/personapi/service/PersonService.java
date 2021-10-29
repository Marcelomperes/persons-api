package mmartins.personapi.service;

import mmartins.personapi.dto.MessageResponseDTO;
import mmartins.personapi.dto.request.PersonDTO;
import mmartins.personapi.entity.Person;
import mmartins.personapi.mapper.PersonMapper;
import mmartins.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + personToSave.getId())
                .build();
    }
}
