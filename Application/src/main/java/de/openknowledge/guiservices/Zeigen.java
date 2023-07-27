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
package de.openknowledge.guiservices;

import de.openknowledge.klasse.Klasse;
import de.openknowledge.lehrer.Lehrer;
import de.openknowledge.printing.MyBufferedReader;
import de.openknowledge.schueler.Schueler;

public class Zeigen {
    public void alleKlassenZeigen(KlassenList klasses) {
        MyBufferedReader.print(klasses.getKlasses().toString());
    }

    public void alleSchuelerZeigen(SchuelerList schuelers) {
        MyBufferedReader.print(schuelers.toString());
    }

    public void alleLehrerZeigen(LehrerList lehrers) {
        MyBufferedReader.print(lehrers.toString());
    }

    public void bestimmteSchulerZeigen(String schuelerNUmmer, SchuelerList schuelers) {
        for (Schueler schueler : schuelers.getSchuelerArrayList()) {
            if (schueler.getSchuelerNummer().equals(schuelerNUmmer)) {
                MyBufferedReader.print(schueler.toString());
                return;
            }
        }
        MyBufferedReader.print("Es gibt kein Schüler mit der Nummer: " + schuelerNUmmer);
    }

    public void bestimmteLehrerZeigen(String lehrerNummer, LehrerList lehrers) {
        for (Lehrer lehrer : lehrers.getLehrerList()) {
            if (lehrer.getLehrerNummer().equals(lehrerNummer)) {
                MyBufferedReader.print(lehrers.toString());
                return;
            }
        }
        MyBufferedReader.print("Es gibt kein Lehrer mit der Nummer: " + lehrerNummer);
    }

    public void bestimmteKlasseZeigen(String klassenName, KlassenList klasses) {
        for (Klasse klasse : klasses.getKlasses()) {
            if (klasse.getName().equals(klassenName)) {
                MyBufferedReader.print(klasse.toString());
                return;
            }
        }
        MyBufferedReader.print("Es gibt kein Klasse mit den Name: " + klassenName);
    }
}
