package com.antoniodjuteski.kniga.repository;

import com.antoniodjuteski.kniga.data.PojoDB;
import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.Kniga;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
public class AvtorRepository {
    public List<Avtor> findAll(){
        return PojoDB.avtori;
    }

    public Map<Avtor, List<Kniga>> getAvtoriSoKnigi(){
        return PojoDB.avtorKnigaMap;
    }


}
