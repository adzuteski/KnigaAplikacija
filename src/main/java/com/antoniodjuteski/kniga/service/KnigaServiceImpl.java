package com.antoniodjuteski.kniga.service;

import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.model.dto.KnigaDTO;
import com.antoniodjuteski.kniga.repository.KnigaRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KnigaServiceImpl implements KnigaService {

    private final KnigaRepository knigaRepository;

    public KnigaServiceImpl(KnigaRepository knigaRepository) {
        this.knigaRepository = knigaRepository;
    }

    @Override
    public Optional<Kniga> findByISBN(String ISBN) {
        return this.knigaRepository.findByISBN(ISBN);
    }

    @Override
    public List<Kniga> findAll() {
        return knigaRepository.findAll();
    }

    @Override
    public Optional<Kniga> save(KnigaDTO knigaDTO) {
        return knigaRepository.save(knigaDTO);
    }

    @Override
    public Optional<Kniga> edit(String ISBN, KnigaDTO knigaDTO) {
        return knigaRepository.edit(ISBN, knigaDTO);
    }

    @Override
    public void delete(String ISBN) {
        knigaRepository.deleteByISBN(ISBN);
    }



    @Override
    public List<Kniga> getKnigiHronoloskiRedosled() {
        return this.knigaRepository.findAll().stream().
                sorted(Comparator.comparing(Kniga::getGodNaIzdavanje)).collect(Collectors.toList());
    }

    @Override
    public List<Kniga> getKnigaPoPrvataBukvaNaAvtorot(String letter) {
        return this.knigaRepository.findAll().stream()
                .filter(kniga->kniga.getAvtor().getPrezime()
                        .startsWith(letter)).collect(Collectors.toList());
    }

    @Override
    public List<Kniga> getNajstaraINajnovaKniga() {
        List<Kniga> knigi = this.knigaRepository.findAll().stream().
                sorted(Comparator.comparing(Kniga::getGodNaIzdavanje)).collect(Collectors.toList());
        List<Kniga> sortiraniPoGodina= new ArrayList<>();
        sortiraniPoGodina.add(knigi.get(0));
        sortiraniPoGodina.add(knigi.get(knigi.size() - 1));
        return sortiraniPoGodina;
    }
}
