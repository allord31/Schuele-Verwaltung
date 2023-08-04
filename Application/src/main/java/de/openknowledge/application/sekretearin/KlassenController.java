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
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.klasse.Klasse;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.exception.KeineKlasse;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

import java.util.ArrayList;

public class KlassenController {
    private final Verwalten verwalten;

    public KlassenController(Verwalten verwalten) {
        this.verwalten = verwalten;
    }
    public void klassenZeigen() {
        for (Klasse klasse : verwalten.getKlassenList()){
            MyBufferedReader.print(Ausgabe.klasseDetails().formatted(klasse.getName(),klasse.getBeschreibung(),klasse.getStufe()));
        }
    }
    public void bestimmteKlasseZeigen (Name klassenName) {
        for (Klasse klasse: verwalten.getKlassenList()){
            if (klasse.getName().equals(klassenName)) {
                MyBufferedReader.print(Ausgabe.klasseDetails().formatted(klasse.getName(),klasse.getBeschreibung(),klasse.getStufe()));
            }
        }
        Ausgabe.klasseNichtGefunden(klassenName);
    }

    public void schuelerInDerKlasseZeigen() {
        Name klassenname = Eingabe.klassenName();
        try {
            schuelerEinzelZeigen(verwalten.getKlasse(klassenname));
        } catch (KeineKlasse e) {
            Ausgabe.klasseNichtGefunden(klassenname);
        }
    }
    private static void schuelerEinzelZeigen(Klasse klasse) {
        for (Schueler schueler: klasse.getSchuelers()) {
            MyBufferedReader.print(Ausgabe.schuelerDetails().formatted(schueler.getSchuelerNummerObje().getSchulerNummer(), schueler.getVorname()
                , schueler.getNachname(), schueler.getGeburtsdatum().toString(), schueler.getAdresse().getAdresses(), schueler.getTelefon()));
        }
    }
    public  void lehrerInderKlasseZeigen() {
        Name klassenname = Eingabe.klassenName();
        try {
            lehrerEinzelZeigen(verwalten.getKlasse(klassenname));
        } catch (KeineKlasse e) {
            Ausgabe.klasseNichtGefunden(klassenname);
        }
    }
    private static void lehrerEinzelZeigen(Klasse klasse) {
        for (Lehrer lehrer: klasse.getLehrers()) {
            MyBufferedReader.print(Ausgabe.lehrerDetails().formatted(lehrer.getLehrerNummerObje().getLehrerNummer(), lehrer.getVorname()
                , lehrer.getNachname(), lehrer.getGeburtsdatum().toString(), lehrer.getAdresse().getAdresses(), lehrer.getTelefon()));
        }
    }



}
