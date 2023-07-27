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
import de.openknowledge.application.guiservices.KopfVonServices;
import de.openknowledge.infrastruktur.validieren.Auswahl;

public class Main {
    public static void main(String[] args) {
        MainInterface.mainInterfaceZeigen();
        KlassenList klassenList = new KlassenList();
        LehrerList lehrerList = new LehrerList();
        SchuelerList schuelerList = new SchuelerList();
        KopfVonServices kopfVonServices = new KopfVonServices(klassenList, lehrerList, schuelerList);
        switch (Auswahl.auswahl(1,5)){
            case 1-> kopfVonServices.zeigen();
            case 2-> kopfVonServices.schuelerOderLehrerInEinerKLasseAddieren();
            case 3-> kopfVonServices.SchulerOderLehrerInEinerKlasseUmsetzen();
        }


    }
}