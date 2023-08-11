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
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.klasse.Klasse;
import de.openknowledge.infrastruktur.exception.UngueltigeEingabe;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;


import java.util.ArrayList;
/**
 * Diese Klasse repräsentiert die Klasse "BereitendeKlassen", die vordefinierte Klassenobjekte erstellt und verwaltet.
 * Sie enthält Methoden zum Abrufen der Liste vordefinierter Klassen.
 *
 * Diese Klasse ist Teil der Anwendung zur Schule verwaltung von open knowledge GmbH.
 *
 * @author open knowledge GmbH
 * @version 1.0
 * @since 11. August 2023
 */
public class BereitendeKlassen {
    private ArrayList<Klasse> klasseArrayList = new ArrayList<>();
    /**
     * Konstruktor für die BereitendeKlassen-Klasse. Er erstellt vordefinierte Klassenobjekte und fügt sie der Liste hinzu.
     */
    public BereitendeKlassen(){

        try {
            Klasse fa1b = new Klasse(new Name("FA1B"), "Fachinformatiker Anwendungsentwicklung", "1", "Kein");
            Klasse fa1c = new Klasse(new Name("FA1C"), "Fachinformatiker Anwendungsentwicklung", "1", "Kein");
            Klasse fa1d = new Klasse(new Name("FA1D"), "Fachinformatiker Anwendungsentwicklung", "1", "Kein");
            klasseArrayList.add(fa1b);
            klasseArrayList.add(fa1c);
            klasseArrayList.add(fa1d);
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage());
        }
    }
    /**
     * Gibt die Liste der vordefinierten Klassen zurück.
     *
     * @return Die Liste der vordefinierten Klassen.
     */
    public ArrayList<Klasse> getKlassenList() {
    return klasseArrayList;
    }

}
