package de.openknowledge.application.sekretearin;/*
 * Copyright (C) open knowledge GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import de.openknowledge.application.einundausgabe.Ausgabe;
import de.openknowledge.application.einundausgabe.Eingabe;
import de.openknowledge.domain.verwaltung.Verwalten;
import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.exception.KeinPerson;
import de.openknowledge.infrastruktur.exception.KeineKlasse;
import de.openknowledge.infrastruktur.exception.PersonExist;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

public class SchuelerController {
    private final Verwalten verwalten;

    public SchuelerController(Verwalten verwalten) {
        this.verwalten = verwalten;
    }
    public void schuelerZeigen() {
        for (Schueler schueler: verwalten.getSchuelerList()) {
            MyBufferedReader.print(Ausgabe.schuelerDetails().formatted(schueler.getSchuelerNummerObje().getSchulerNummer(),schueler.getVorname()
                ,schueler.getNachname(),schueler.getGeburtsdatum().toString(),schueler.getAdresse().getAdresses(), schueler.getTelefon()));
        }
    }
    public void bestimmteSchuelerZeigen(SchuelerNummer schuelerNummer) {
        for (Schueler schueler :verwalten.getSchuelerList()) {
            if (schueler.getSchuelerNummerObje().equals(schuelerNummer)) {
                Ausgabe.schuelerDetails().formatted(schueler.getSchuelerNummerObje().getSchulerNummer(), schueler.getVorname()
                    , schueler.getNachname(), schueler.getGeburtsdatum().toString(), schueler.getAdresse().getAdresses(), schueler.getTelefon());
                return;
            }
        }
        Ausgabe.schuelerNichtGefunden(schuelerNummer);
    }

    public void schuelerUmsetzen() {
        SchuelerNummer schuelerNummer = Eingabe.schuelerNummer();
        Name klassenName = Eingabe.klassenName();
        try {
            verwalten. schuelerUmsetzen(klassenName, schuelerNummer);
        } catch (KeinPerson e) {
            Ausgabe.schuelerNichtGefunden(schuelerNummer);
        } catch (KeineKlasse e) {
            Ausgabe.klasseNichtGefunden(klassenName);
        } catch (PersonExist e) {
            Ausgabe.schuelerIstInDieseKlasse(klassenName,  schuelerNummer);
        }
    }

    public void schuelerAddieren() {
        Name klassenName = Eingabe.klassenName();
        SchuelerNummer schuelerNummer= Eingabe.schuelerNummer();
        try {
            verwalten.addSchuelerInKlasse(klassenName, schuelerNummer);
        } catch (KeineKlasse e) {
            Ausgabe.klasseNichtGefunden(klassenName);
        } catch (KeinPerson e) {
            Ausgabe.schuelerNichtGefunden(schuelerNummer);
        }
    }
}
