import model.Chitara;
import model.SetTobe;
import model.TipChitara;
import model.TipTobe;
import service.InstrumenteService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            InstrumenteService service = new InstrumenteService();

            // Adăugare instrumente
            service.getInstrumente().add(new Chitara("Fender", 2000, TipChitara.ELECTRICA, 6));
            service.getInstrumente().add(new Chitara("Yamaha", 1500, TipChitara.ACUSTICA, 12));
            service.getInstrumente().add(new SetTobe("Roland", 5000, TipTobe.ELECTRONICE, 5, 3));

            // Salvare și încărcare
            service.salveazaInstrumenteInFisier();
            service.incarcaInstrumenteDinFisier();

            // Operații adiționale
            System.out.println("Instrumente: " + service.getInstrumente());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
