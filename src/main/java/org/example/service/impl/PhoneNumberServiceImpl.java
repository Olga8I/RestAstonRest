package org.example.service.impl;

import org.example.dto.PhoneNumberDto;
import org.example.exception.NotFoundException;
import org.example.model.PhoneNumber;
import org.example.repository.PhoneNumberRepository;
import org.example.mapper.PhoneNumberMapper; // Изменил на PhoneNumberMapper
import org.example.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Использование аннотации Spring для управления жизненным циклом бинов
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private final PhoneNumberMapper phoneNumberMapper; // Изменил на PhoneNumberMapper
    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberServiceImpl(PhoneNumberMapper phoneNumberMapper, PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberMapper = phoneNumberMapper;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public void save(PhoneNumberDto phoneNumberDto) {
        PhoneNumber phoneNumber = phoneNumberMapper.mapToEntity(phoneNumberDto);
    }

    @Override
    public void update(PhoneNumberDto phoneNumberDto) throws NotFoundException {
        if (phoneNumberRepository.existsById(phoneNumberDto.getId())) {
            PhoneNumber phoneNumber = phoneNumberMapper.mapToEntity(phoneNumberDto);
            phoneNumberRepository.save(phoneNumber);
        } else {
            throw new NotFoundException("PhoneNumber not found.");
        }
    }

    @Override
    public PhoneNumberDto findById(Long phoneNumberId) throws NotFoundException {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(phoneNumberId)
                .orElseThrow(() -> new NotFoundException("PhoneNumber not found."));
        return phoneNumberMapper.mapToDto(phoneNumber);
    }

    @Override
    public List<PhoneNumberDto> findAll() {
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.findAll();
        return phoneNumberMapper.mapToListToDto(phoneNumberList);
    }

    @Override
    public void delete(Long phoneNumberId) {
         phoneNumberRepository.deleteById(phoneNumberId);
    }
}

