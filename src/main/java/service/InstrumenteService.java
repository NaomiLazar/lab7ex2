package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Chitara;
import model.InstrumentMuzical;
import model.SetTobe;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class InstrumenteService {
    private final ObjectMapper mapper;
    private final File fisierInstrumente = new File("src/main/resources/instrumente.json");
    private Set<InstrumentMuzical> instrumente;

    public InstrumenteService() throws IOException {
        this.mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        this.instrumente = new HashSet<>();
    }

    public void incarcaInstrumenteDinFisier() throws IOException {
        if (fisierInstrumente.exists()) {
            this.instrumente = mapper.readValue(fisierInstrumente, HashSet.class);
        }
    }

    public void salveazaInstrumenteInFisier() throws IOException {
        mapper.writeValue(fisierInstrumente, instrumente);
    }

    public Set<InstrumentMuzical> getInstrumente() {
        return instrumente;
    }
}

