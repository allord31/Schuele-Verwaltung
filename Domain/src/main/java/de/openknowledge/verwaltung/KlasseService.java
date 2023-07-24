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
package de.openknowledge.verwaltung;

import de.openknowledge.klasse.BereitendeKlassen;
import de.openknowledge.klasse.Klasse;
import de.openknowledge.klasse.KlassenList;
import de.openknowledge.printing.MyBufferedReader;

public class KlasseService {
    private KlassenList klassenList;
    public KlasseService() {
        klassenList = new KlassenList();
        BereitendeKlassen bereitendeKlassen = new BereitendeKlassen();
        for (Klasse klasse: bereitendeKlassen.getKlassenList()){
            klassenList.addKlasse(klasse);
        }
    }

    public void addNeuKlasse(String name, String beschreibung, String stufe, String klassenlehrer) {
        Klasse klasse = new Klasse(name, beschreibung, stufe, klassenlehrer);
        klassenList.addKlasse(klasse);
    }
    public void removeKlasse(String name) {
        for (Klasse klasse: klassenList.getKlasses()) {
            if (klasse.getName().equals(name)){
                klassenList.removeKlasse(klasse);
                return;
            }
        }
        MyBufferedReader.print("Es gibt kein Klasse heißt: " + name);
    }

    public KlassenList getKlassenList() {
        return klassenList;
    }
}
