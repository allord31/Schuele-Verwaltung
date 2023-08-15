package de.openknowledge.application.testdata;/*
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

import de.openknowledge.domain.verwaltung.klasse.Klasse;

import de.openknowledge.domain.verwaltung.lehrer.Lehrer;

import de.openknowledge.domain.verwaltung.schueler.Schueler;

import java.util.ArrayList;

public class DataBank {
    private ArrayList<Klasse> bereitendeKlassen = new ArrayList<>();
    private ArrayList<Lehrer> bereitendeLehrer = new ArrayList<>();
    private ArrayList<Schueler> bereitendeSchueler = new ArrayList<>();


    public DataBank() {
    }
    public DataBank(BereitendeKlassen bereitendeKlassen, BereitendeLehrer bereitendeLehrer, BereitendeSchueler bereitendeSchueler) {
        this.bereitendeKlassen.addAll(bereitendeKlassen.getKlassenList());
        this.bereitendeLehrer.addAll(bereitendeLehrer.getlehrer());
        this.bereitendeSchueler.addAll(bereitendeSchueler.getSchueler());
    }


    public ArrayList<Klasse> getKlassenArray() {
        lehrerVerteilenKlasse(bereitendeKlassen, bereitendeLehrer);
        schuelerVerteilenInKlasse(bereitendeKlassen, bereitendeSchueler);
        return bereitendeKlassen;
    }
    public ArrayList<Lehrer> getLehrerArray() {
        return bereitendeLehrer;
    }
    public ArrayList<Schueler> getSchuelerArray(){
        return bereitendeSchueler;
    }
    private static void schuelerVerteilenInKlasse(ArrayList<Klasse> klasseArrayList, ArrayList<Schueler> schuelerArrayList) {
        int counter = 0;
        for (Klasse klasse: klasseArrayList) {
            klasse.addSchueler(schuelerArrayList.get(counter));
            klasse.addSchueler(schuelerArrayList.get(3 + counter));
            klasse.addSchueler(schuelerArrayList.get(6 + counter));
            counter++;
        }
    }
    private static void lehrerVerteilenKlasse(ArrayList<Klasse> klasseArrayList, ArrayList<Lehrer> lehrerArrayList) {
        int counter = 0;
        for (Klasse klasse:klasseArrayList) {
            klasse.addLehrer(lehrerArrayList.get((counter)));
            klasse.addLehrer(lehrerArrayList.get((3 + counter)));
            klasse.addLehrer(lehrerArrayList.get((6 + counter)));
            counter++;
        }
    }

}
