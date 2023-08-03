package de.openknowledge.application.guiservices;
/*
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

import de.openknowledge.application.controlinterface.MainInterface;
import de.openknowledge.application.einundausgabe.Eingabe;
import de.openknowledge.application.sekretearin.KlassenController;
import de.openknowledge.application.sekretearin.LehrerController;
import de.openknowledge.application.sekretearin.SchuelerController;
import de.openknowledge.domain.verwaltung.Verwalten;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;

public class KopfVonServices {
    Verwalten verwalten;
    KlassenController klassenController;
    LehrerController lehrerController;
    SchuelerController schuelerController;

    public KopfVonServices(Verwalten verwalten) {
        this.verwalten = verwalten;
        klassenController = new KlassenController(verwalten);
        lehrerController = new LehrerController(verwalten);
        schuelerController = new SchuelerController(verwalten);
    }

    public void zeigen() {
        MainInterface.wasWollenSieZeigen();
        verwalten.getLehrerList().add(new Lehrer());
        switch (Eingabe.auswahl(1,6)) {
            case 1-> klassenController.klassenZeigen();
            case 2-> lehrerController.lehrerZeigen();
            case 3-> schuelerController.schuelerZeigen();
            case 4-> klassenController.bestimmteKlasseZeigen(Eingabe.klassenName());
            case 5-> lehrerController.bestimmteLehrerZeigen(Eingabe.lehrerNummer());
            case 6-> schuelerController.bestimmteSchuelerZeigen(Eingabe.schuelerNummer());
        }
    }
    public void umsetzen() {
        MainInterface.wasUmsetzen();
        switch (Eingabe.auswahl(1,2)) {
            case 1-> lehrerController.lehrerUmsetzen();
            case 2-> schuelerController.schuelerUmsetzen();
        }
    }

    public void neuSchuerlerOderLehrerEinfuegen() {
        MainInterface.wasAddieren();
        switch (Eingabe.auswahl(1,2)){
            case 1-> lehrerController.lehrerAddieren();
            case 2-> schuelerController.schuelerAddieren();
        }

    }
}
