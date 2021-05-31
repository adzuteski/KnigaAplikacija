package com.antoniodjuteski.kniga.service;

import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.model.dto.KnigaDTO;
import java.util.List;
import java.util.Optional;

public interface KnigaService {
    //CRUD
    Optional<Kniga>findByISBN (String ISBN);
    List<Kniga> findAll();
    Optional<Kniga> save(KnigaDTO knigaDTO);
    Optional<Kniga> edit(String ISBN, KnigaDTO bookDto);
    void delete(String ISBN);

    //zadaca
    List<Kniga> getKnigiHronoloskiRedosled();
    List<Kniga> getKnigaPoPrvataBukvaNaAvtorot(String letter);
    List<Kniga> getNajstaraINajnovaKniga();

}
