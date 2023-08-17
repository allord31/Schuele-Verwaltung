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
package de.openknowledge.application.gui;

import de.openknowledge.application.controlinterface.MainInterface;
import de.openknowledge.application.einundausgabe.Eingabe;
import de.openknowledge.application.guiservices.KopfVonServices;
import de.openknowledge.application.testdata.BereitendeKlassen;
import de.openknowledge.application.testdata.BereitendeLehrer;
import de.openknowledge.application.testdata.BereitendeSchueler;
import de.openknowledge.application.testdata.DataBank;
import de.openknowledge.domain.verwaltung.Verwalten;

import org.apache.log4j.Logger;


public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        //testdata
        log.warn("Anwendung ist gestartet.");
        DataBank dataBank = new DataBank();
        if (System.getenv("TEST_DATA_AKTIVIERT").equals("aktiviert")) {
            BereitendeKlassen bereitendeKlassen = new BereitendeKlassen();
            BereitendeLehrer bereitendeLehrer = new BereitendeLehrer();
            BereitendeSchueler bereitendeSchueler = new BereitendeSchueler();
            dataBank = new DataBank(bereitendeKlassen, bereitendeLehrer, bereitendeSchueler);
            log.info("Test Data wurde erstellt.");
        }
        //Create verwaltung
        Verwalten verwalten = new Verwalten(dataBank.getKlassenArray(), dataBank.getLehrerArray(), dataBank.getSchuelerArray());

        //create interface and controller
        KopfVonServices kopfVonServices = new KopfVonServices(verwalten);
        while (true) {
            MainInterface.mainInterfaceZeigen();
            switch (Eingabe.auswahl(1, 6)) {
                case 1 -> kopfVonServices.zeigen();
                case 2 -> kopfVonServices.umsetzen();
                case 3 -> kopfVonServices.neuSchuerlerOderLehrerEinfuegen();
                case 4 -> kopfVonServices.entfernenLehrerOderSchuelerVonSchule();
                case 5 -> kopfVonServices.setSprache();
                case 6 -> {
                    log.info("Der benutzer hat die Anwendung beenden.");
                    System.exit(0);
                }
            }
        }


    }
}