package com.antoniodjuteski.kniga;

import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.service.AvtorService;
import com.antoniodjuteski.kniga.service.KnigaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private AvtorService avtorService;
    @Autowired
    private KnigaService knigaService;

    @Test
    public void testZaAvtoriSoPovekeOdTriKnigi(){
        List<Avtor> avtori = this.avtorService.getAvtoriSoPovekeOdTriKnigi();
        for (Avtor avtor : avtori){
            Assert.assertTrue(avtorService.getAvtoriSoKnigi().get(avtor).size()>3);
        }
    }

    @Test
    public void testKnigaPoPrvataBukvaNaAvtorot(){
        List<Kniga> knigi = this.knigaService.getKnigaPoPrvataBukvaNaAvtorot("V");
        for(Kniga kniga: knigi){
            Assert.assertEquals('V', kniga.getAvtor().getPrezime().charAt(0));
        }
    }

    @Test
    public void testKnigiHronoloskiRedosled(){
        List<Kniga> knigi = this.knigaService.getKnigiHronoloskiRedosled();
        Kniga najstara = this.knigaService.getNajstaraINajnovaKniga().get(0);
        Assert.assertEquals(knigi.get(0), najstara);
        Kniga najnova = this.knigaService.getNajstaraINajnovaKniga().get(1);
        Assert.assertEquals(knigi.get(knigi.size() - 1), najnova);
    }
}
