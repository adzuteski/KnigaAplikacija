package com.antoniodjuteski.kniga.controller;

import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.model.dto.KnigaDTO;
import com.antoniodjuteski.kniga.service.AvtorService;
import com.antoniodjuteski.kniga.service.KnigaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/knigi")
public class KnigaRestContorller {

   private final KnigaService knigaService;
   private final AvtorService avtorService;

    public KnigaRestContorller(KnigaService knigaService, AvtorService avtorService) {
        this.knigaService = knigaService;
        this.avtorService = avtorService;
    }

    @GetMapping
    public List<Kniga> findAll(){
        return this.knigaService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Kniga> save(@RequestBody KnigaDTO knigaDTO) {
        return this.knigaService.save(knigaDTO)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{ISBN}")
    public ResponseEntity<Kniga> delete(@PathVariable String ISBN){
        this.knigaService.delete(ISBN);
        if(this.knigaService.findByISBN(ISBN).isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/avtori")
    public Map<Avtor, List<Kniga>> getAvtoriSoKnigi(){
        return this.avtorService.getAvtoriSoKnigi();
    }

    @GetMapping("/knigiHronloskiRedosled")
    public List<Kniga> getKnigiHronoloskiRedosled(){
        return this.knigaService.getKnigiHronoloskiRedosled();
    }

    @GetMapping("/knigiPoPrvataBukvaNaAvtorot/{letter}")
    public List<Kniga> getKnigaPoPrvataBukvaNaAvtorot(@PathVariable String s){
        return this.knigaService.getKnigaPoPrvataBukvaNaAvtorot(s);
    }

    @GetMapping("/najstaraiNajnova")
    public List<Kniga> getNajstaraINajnovaKniga(){
        return this.knigaService.getNajstaraINajnovaKniga();
    }

    @GetMapping("/avtoriSoPovekeOdTriKnigi")
    public List<Avtor> getAvtoriSoPovekeOdTriKnigi() {
        return this.avtorService.getAvtoriSoPovekeOdTriKnigi();
    }



}
