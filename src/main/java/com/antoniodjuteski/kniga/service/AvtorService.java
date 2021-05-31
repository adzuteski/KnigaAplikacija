package com.antoniodjuteski.kniga.service;

import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.Kniga;

import java.util.List;
import java.util.Map;

public interface AvtorService {

    Map<Avtor, List<Kniga>> getAvtoriSoKnigi();

    List<Avtor> getAvtoriSoPovekeOdTriKnigi();

}
