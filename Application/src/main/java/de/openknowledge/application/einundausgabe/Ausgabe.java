package de.openknowledge.application.einundausgabe;/*
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

import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

public class Ausgabe {
    public static void klasseNichtGefunden(Name klassenName) {
        MyBufferedReader.print("Dies Klasse "+ klassenName.getName()+ " ist nicht exist.");
    }
    public static String klasseDetails() {
        return """
                Klasse Name: %s
                Klasse beschreibung: %s
                klasse Stufe: %s""";
    }
    public static void lehrerNichtGefunden(LehrerNummer lehrerNummer) {
        MyBufferedReader.print("Diese Lehrer mit der Nummer "+ lehrerNummer.getLehrerNummer() +" ist nicht exist.");
    }
    public static void lehrerIstInDieseKlasse(Name klassenname,LehrerNummer lehrerNummer) {
        MyBufferedReader.print("Diese Lehrer mit der Nummer "+ lehrerNummer.getLehrerNummer() +" ist in diese Klasse " +klassenname.getName()+" bereit exist.");
    }
    public static void lehrerIstInDerSchuele(Lehrer lehrer) {
        MyBufferedReader.print("Diese Lehrer " + lehrer.getVorname() + " " + lehrer.getNachname()
            +" ist schon bereit eingefügt worden.");
    }
    public static void lehrerEntfernen(LehrerNummer lehrerNummer) {
        MyBufferedReader.print("Diese Lehrer mit der Nummer: " + lehrerNummer.getLehrerNummer() + " ist nicht in der Schule, um zu entfernen.");
    }
    public static String lehrerDetails() {
        return """
                
                Lehrer Nummer: %s, Lehrer Vorname: %s, Lehrer Nachname: %s, Geburtsdatum: %s
                Adresse: %s
                Telefon Nummer: %s""";
    }
    public static void schuelerNichtGefunden(SchuelerNummer schuelerNummer) {
        MyBufferedReader.print("Diese Schüler mit der Nummer "+ schuelerNummer.getSchulerNummer() +" ist nicht exist.");
    }
    public static void schuelerIstInDieseKlasse(Name klassenname, SchuelerNummer schuelerNummer) {
        MyBufferedReader.print("Diese Schüler mit der Nummer "+ schuelerNummer.getSchulerNummer() +" ist in diese Klasse " +klassenname.getName()+" bereit exist.");
    }
    public static void schuelerIstInDerSchuele(Schueler schueler) {
        MyBufferedReader.print("Diese Schüler " + schueler.getVorname() + " " + schueler.getNachname()
            +" ist schon bereit eingefügt worden.");
    }
    public static void schuelerEntfernen(SchuelerNummer schuelerNummer) {
        MyBufferedReader.print("Diese Schüler mit der Nummer: " + schuelerNummer.getSchulerNummer() + " ist nicht in der Schule, um zu entfernen.");
    }

    public static String schuelerDetails() {
        return """
                
                Schüler Nummer: %s, Schüler Vorname: %s, Schüler Nachname: %s, Geburtsdatum: %s
                Adresse: %s
                Telefon Nummer: %s
                """;
    }
    public static void neuVersuch() {
        MyBufferedReader.print("Wollen Sie erneut versuchen. 1. Ja oder 2. Nein ");
    }


}
