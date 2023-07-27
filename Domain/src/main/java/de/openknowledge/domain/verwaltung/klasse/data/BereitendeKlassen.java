package de.openknowledge.domain.verwaltung.klasse.data;/*
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


import java.util.ArrayList;

public class BereitendeKlassen {
    ArrayList<Klasse> klasseArrayList = new ArrayList<>();
    public ArrayList<Klasse> getKlassenList() {
    Klasse fa1b = new Klasse("FA1B", "Fachinformatiker anwendungsentwicklung", "1", "Kein");
    Klasse fa1c = new Klasse("FA1C", "Fachinformatiker Anwendungsentwicklung", "1", "Kein");
    Klasse fa1d = new Klasse("Fa1D", "Fachinformatiker Anwendungsentwicklung", "1", "Kein");
    klasseArrayList.add(fa1b);
    klasseArrayList.add(fa1c);
    klasseArrayList.add(fa1d);
    return klasseArrayList;
    }

}
