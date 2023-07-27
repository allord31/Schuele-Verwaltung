package de.openknowledge.guiservices;/*
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

import de.openknowledge.controlinterface.MainInterface;
import de.openknowledge.printing.MyBufferedReader;
import de.openknowledge.validieren.Auswahl;

import java.util.Scanner;

public class KopfVonServices {
    private KlassenList klassenList;
    private LehrerList lehrerList;
    private SchuelerList schuelerList;
    private KlasseService klasseService = new KlasseService();
    private Scanner input = new Scanner(System.in);
    public KopfVonServices(KlassenList klassenList, LehrerList lehrerList, SchuelerList schuelerList) {
        this.klassenList = klassenList;
        this.lehrerList = lehrerList;
        this.schuelerList = schuelerList;
    }
    public void zeigen() {
        MainInterface.wasWollenSieZeigen();
        Zeigen wasWollenZeigen = new Zeigen();
        switch (Auswahl.auswahl(1,6)) {
            case 1-> wasWollenZeigen.alleKlassenZeigen(klassenList);
            case 2-> wasWollenZeigen.alleLehrerZeigen(lehrerList);
            case 3-> wasWollenZeigen.alleSchuelerZeigen(schuelerList);
            case 4-> {
                MyBufferedReader.print("Geben Sie Die Klassen Name ein: ");
                String klassenName = input.nextLine();
                wasWollenZeigen.bestimmteKlasseZeigen(klassenName, klassenList);
            }
            case 5-> {
                MyBufferedReader.print("Geben Sie Die Lehrer Nummer ein");
                String lehrerNummer = input.nextLine();
                wasWollenZeigen.bestimmteLehrerZeigen(lehrerNummer, lehrerList);
            }
            case 6-> {
                MyBufferedReader.print("Geben Sie Die Schüler Nummer ein");
                String schuelerNummer = input.nextLine();
                wasWollenZeigen.bestimmteSchulerZeigen(schuelerNummer,schuelerList);
            }
        }
    }
    public void SchulerOderLehrerInEinerKlasseUmsetzen() {
        MainInterface.wasUmsetzen();
        switch (Auswahl.auswahl(1,2)){
            case 1->klasseService.schuelerUmsetzen(klassenList, schuelerList);
            case 2->klasseService.lehrerUmsetzen(klassenList, lehrerList);
        }
    }
    public void schuelerOderLehrerInEinerKLasseAddieren() {
        MainInterface.wasAddieren();
        switch (Auswahl.auswahl(1,2)){
           case 1-> klasseService.addNeuLehrerInBestimmteKlasse(klassenList, lehrerList);
           case 2-> klasseService.addNeuSchuelerInBestimmteKlasse(klassenList,schuelerList);
        }
    }
}
