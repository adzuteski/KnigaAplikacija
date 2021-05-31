package com.antoniodjuteski.kniga.repository;

import com.antoniodjuteski.kniga.data.PojoDB;
import com.antoniodjuteski.kniga.model.Ebook;
import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.model.PrintCopy;
import com.antoniodjuteski.kniga.model.dto.KnigaDTO;
import com.antoniodjuteski.kniga.model.enums.TipNaKniga;
import com.antoniodjuteski.kniga.model.exception.NemaTakvaKnigaException;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class KnigaRepository {

    public List<Kniga> findAll(){
        return PojoDB.knigi;
    }

    public Optional<Kniga> findByISBN(String ISBN){
        return PojoDB.knigi.stream().filter(s->s.getISBN().equals(ISBN)).findFirst();
    }

    public Optional<Kniga> save(KnigaDTO knigaDTO){
        Kniga kniga;
        PojoDB.knigi.removeIf(s->s.getISBN().equals(knigaDTO.getISBN()));
        if(knigaDTO.getTipNaKniga().equals(TipNaKniga.E_BOOK)){
            kniga = new Ebook(knigaDTO.getNaslov(), knigaDTO.getISBN(), knigaDTO.getGodNaIzdavanje(), knigaDTO.getAvtor(), knigaDTO.getFormat(), knigaDTO.getGoleminaVoMB());
            PojoDB.knigi.add(kniga);
            if(!PojoDB.avtorKnigaMap.containsKey(kniga.getAvtor())){
                PojoDB.avtorKnigaMap.put(kniga.getAvtor(), new ArrayList<>());
            }
            PojoDB.avtorKnigaMap.get(kniga.getAvtor()).add(kniga);
        }
        else {
            kniga = new PrintCopy(knigaDTO.getNaslov(), knigaDTO.getISBN(), knigaDTO.getGodNaIzdavanje(), knigaDTO.getAvtor(), knigaDTO.getBrojNaStrani(), knigaDTO.getTezina());
            PojoDB.knigi.add(kniga);
            if(!PojoDB.avtorKnigaMap.containsKey(kniga.getAvtor())){
                PojoDB.avtorKnigaMap.put(kniga.getAvtor(), new ArrayList<>());
            }
            PojoDB.avtorKnigaMap.get(kniga.getAvtor()).add(kniga);
        }
        return Optional.of(kniga);
    }

    public Optional<Kniga> edit(String ISBN, KnigaDTO knigaDTO){
        Kniga editiranaKniga;
        Kniga kniga = this.findByISBN(ISBN).orElseThrow(() -> new NemaTakvaKnigaException(ISBN));
        PojoDB.knigi.remove(kniga);
        if(knigaDTO.getTipNaKniga().equals(TipNaKniga.E_BOOK)){
            editiranaKniga = new Ebook(knigaDTO.getNaslov(), ISBN, knigaDTO.getGodNaIzdavanje(), knigaDTO.getAvtor(), knigaDTO.getFormat(), knigaDTO.getGoleminaVoMB());
            PojoDB.knigi.add(editiranaKniga);
        }
        else {
            editiranaKniga = new PrintCopy(knigaDTO.getNaslov(), ISBN, knigaDTO.getGodNaIzdavanje(), knigaDTO.getAvtor(), knigaDTO.getBrojNaStrani(), knigaDTO.getTezina());
            PojoDB.knigi.add(editiranaKniga);
        }
        PojoDB.avtorKnigaMap.get(kniga.getAvtor()).removeIf(s->s.getISBN().equals(ISBN));
        PojoDB.avtorKnigaMap.get(kniga.getAvtor()).add(editiranaKniga);
        return Optional.of(editiranaKniga);
    }

    public void deleteByISBN(String ISBN){
        Kniga kniga = this.findByISBN(ISBN).orElseThrow(() -> new NemaTakvaKnigaException(ISBN));
        PojoDB.knigi.remove(kniga);
        PojoDB.avtorKnigaMap.get(kniga.getAvtor()).removeIf(s->s.getISBN().equals(kniga.getISBN()));
    }
}
