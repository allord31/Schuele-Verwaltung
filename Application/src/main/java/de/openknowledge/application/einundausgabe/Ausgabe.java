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

import de.openknowledge.application.guiservices.KopfVonServices;
import de.openknowledge.application.guiservices.Sprachen;
import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

import java.util.ResourceBundle;

public class Ausgabe {
    private static ResourceBundle resourceBundle = new Sprachen().getResourceBundle();
    public static void setResourceBundle(ResourceBundle setResourceBundle) {
        resourceBundle = setResourceBundle;
    }
    public static void klasseNichtGefunden(Name klassenName) {
        MyBufferedReader.print(resourceBundle.getString("klasseNichtGefunden").formatted(klassenName));
    }
    public static String klasseDetails() {
        return resourceBundle.getString("klasseDetails");
    }
    public static void lehrerNichtGefunden(LehrerNummer lehrerNummer) {
        MyBufferedReader.print(resourceBundle.getString("lehrerNichtGefunden").formatted(lehrerNummer));
    }
    public static void lehrerIstInDieseKlasse(Name klassenname,LehrerNummer lehrerNummer) {
        MyBufferedReader.print(resourceBundle.getString("lehrerIstInDieseKlasse").formatted(lehrerNummer.getLehrerNummer(),klassenname));
    }
    public static void lehrerIstInDerSchuele(Lehrer lehrer) {
        MyBufferedReader.print(resourceBundle.getString("lehrerIstInDerSchuele").formatted(lehrer.getVorname(),lehrer.getNachname()));
    }
    public static void lehrerEntfernen(LehrerNummer lehrerNummer) {
        MyBufferedReader.print(resourceBundle.getString("lehrerEntfernen").formatted(lehrerNummer.getLehrerNummer()));
    }
    public static String lehrerDetails() {
        return resourceBundle.getString("lehrerDetails");
    }
    public static void schuelerNichtGefunden(SchuelerNummer schuelerNummer) {
        MyBufferedReader.print(resourceBundle.getString("schuelerNichtGefunden").formatted(schuelerNummer.getSchulerNummer()));
    }
    public static void schuelerIstInDieseKlasse (Name klassenname, SchuelerNummer schuelerNummer) {
        MyBufferedReader.print(resourceBundle.getString("schuelerIstInDieseKlasse").formatted(schuelerNummer.getSchulerNummer(),klassenname.getName()));
    }
    public static void schuelerIstInDerSchuele(Schueler schueler) {
        MyBufferedReader.print(resourceBundle.getString("schuelerIstInDerSchuele").formatted(schueler.getVorname(), schueler.getNachname()));
    }
    public static void schuelerEntfernen(SchuelerNummer schuelerNummer) {
        MyBufferedReader.print(resourceBundle.getString("schuelerEntfernen").formatted(schuelerNummer.getSchulerNummer()));
    }

    public static String schuelerDetails() {
        return resourceBundle.getString("schuelerDetails");
    }
    public static void neuVersuch() {
        MyBufferedReader.print(resourceBundle.getString("neuVersuch"));
    }

}
