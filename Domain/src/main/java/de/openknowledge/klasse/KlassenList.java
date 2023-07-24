package de.openknowledge.klasse;
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

import java.util.ArrayList;

public class KlassenList {
    private ArrayList<Klasse> klasses;
    public KlassenList(){
        klasses = new ArrayList<>();
    }

    public ArrayList<Klasse> getKlasses() {
        return klasses;
    }
    public void addKlasse(Klasse klasse) {
        klasses.add(klasse);
    }
    public void removeKlasse(Klasse klasse){
        klasses.remove(klasse);
    }

    @Override
    public String toString() {
        return "KlassenList{" +
            "klasses=" + klasses +
            '}';
    }
}
