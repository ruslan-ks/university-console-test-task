package com.rkostiuk.uconsole.service;

import com.rkostiuk.uconsole.repository.LectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataJpaLectorService implements LectorService {
    private final LectorRepository lectorRepository;

    public DataJpaLectorService(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public List<String> findNamesContainingIgnoreCase(String string) {
        return lectorRepository.findNamesLikeIgnoreCase('%' + string + '%');
    }
}
