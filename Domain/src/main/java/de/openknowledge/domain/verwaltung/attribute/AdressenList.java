package de.openknowledge.domain.verwaltung.attribute;/*
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


import de.openknowledge.infrastruktur.printing.MyBufferedReader;

import java.util.ArrayList;

public class AdressenList {
    ArrayList<Adresse> adresses = new ArrayList<>();
    public AdressenList () {

    }
    public  AdressenList (Adresse adresse) {
        adresses.add(adresse);
    }
    public void addNeuAdresse (Adresse neuadresse) {
        for(Adresse adresse: adresses){
            if (adresse.equals(neuadresse)) {
                MyBufferedReader.print("Diese adresse wurde besetzt.");
                return;
            } else {
                adresses.add(neuadresse);
            }
        }
    }
    public void remove (Adresse adresse) {
        adresses.remove(adresse);
    }

    public ArrayList<Adresse> getAdresses() {
        return adresses;
    }

}
