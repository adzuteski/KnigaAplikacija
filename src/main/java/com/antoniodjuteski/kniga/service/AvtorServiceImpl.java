package com.antoniodjuteski.kniga.service;


import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.repository.AvtorRepository;
import com.antoniodjuteski.kniga.repository.KnigaRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AvtorServiceImpl implements AvtorService {

    private final AvtorRepository avtorRepository;
    private final KnigaRepository knigaRepository;

    public AvtorServiceImpl(AvtorRepository avtorRepository, KnigaRepository knigaRepository) {
        this.avtorRepository = avtorRepository;
        this.knigaRepository = knigaRepository;
    }

    @Override
    public Map<Avtor, List<Kniga>> getAvtoriSoKnigi() {
        return this.avtorRepository.getAvtoriSoKnigi();
    }

    @Override
    public List<Avtor> getAvtoriSoPovekeOdTriKnigi() {
        List<Avtor> avtori = new ArrayList<>();
        Map<Avtor, List<Kniga>> authorsWithBooks = this.avtorRepository.getAvtoriSoKnigi();
        for (Avtor avtor : getAvtoriSoKnigi().keySet()) {
            if (getAvtoriSoKnigi().get(avtor).size() > 3) {
                avtori.add(avtor);
            }
        }
        return avtori;
    }



}
