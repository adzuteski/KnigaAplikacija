package com.antoniodjuteski.kniga.data;

import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.Ebook;
import com.antoniodjuteski.kniga.model.Kniga;
import com.antoniodjuteski.kniga.model.PrintCopy;
import com.antoniodjuteski.kniga.model.enums.Format;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class PojoDB {
    public static List<Kniga> knigi = new ArrayList<>();
    public static List<Avtor> avtori = new ArrayList<>();
    public static Map<Avtor, List<Kniga>> avtorKnigaMap = new HashMap<>();



    @PostConstruct
    public void init() {
        avtori.add(new Avtor("Victor", "Hugo", 1802));
        avtori.add(new Avtor("Dan ", "Brown", 1964));
        avtori.add(new Avtor("Jules", "Verne", 1828));
        avtori.add(new Avtor("Venko", "Andonovski", 1964));
        avtori.add(new Avtor("Slavko", "Janevski", 1920));
        for (Avtor avtor : avtori) {
            avtorKnigaMap.put(avtor, new ArrayList<Kniga>());
        }

        knigi.add(new Ebook("Tvrdoglavi", "1234567890", 1969, avtori.get(4), Format.EPUB, 165));
        knigi.add(new PrintCopy("Papokot na svetot", "2345678901-234", 2000, avtori.get(3), 150, 0.5));
        knigi.add(new Ebook("Vestica", "3456789012-123", 2003, avtori.get(3), Format.HTML5, 600));
        knigi.add(new Ebook("kodot na DA Vinci", "4567890123456", 2003, avtori.get(1), Format.PDF, 452));
        knigi.add(new PrintCopy("Digitalna Tvrdina", "5678901234-567", 1998, avtori.get(1), 222, 1.5));
        knigi.add(new PrintCopy("12 000 milji pod moreto", "6789012345", 1858, avtori.get(2), 350, 1));
        knigi.add(new PrintCopy("Bodorodicnata crkva od Pariz", "7890123456", 1829, avtori.get(0), 222, 1.5));
        knigi.add(new PrintCopy("Pat okolu svetot za 80 dena", "8901234567", 1818, avtori.get(2), 350, 1));

        for (Kniga kniga : knigi) {
            avtorKnigaMap.get(kniga.getAvtor()).add(kniga);
        }
    }


}
