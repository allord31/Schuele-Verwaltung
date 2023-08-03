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
    private BereitendeKlassen bereitendeKlassen;
    private BereitendeLehrer bereitendeLehrer;
    private BereitendeSchueler bereitendeSchueler ;


    public DataBank(BereitendeKlassen bereitendeKlassen, BereitendeLehrer bereitendeLehrer, BereitendeSchueler bereitendeSchueler) {
        this.bereitendeKlassen = bereitendeKlassen;
        this.bereitendeLehrer = bereitendeLehrer;
        this.bereitendeSchueler = bereitendeSchueler;
    }


    public ArrayList<Klasse> getKlassenArray() {
        return bereitendeKlassen.getKlassenList();
    }
    public ArrayList<Lehrer> getLehrerArray() {
        return bereitendeLehrer.getlehrer();
    }
    public ArrayList<Schueler> getSchuelerArray(){
        return bereitendeSchueler.getSchueler();
    }


}
