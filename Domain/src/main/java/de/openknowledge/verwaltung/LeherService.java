package de.openknowledge.verwaltung;/*
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

import de.openknowledge.attribute.Adresse;
import de.openknowledge.attribute.Name;
import de.openknowledge.attribute.Telefon;
import de.openknowledge.attribute.adresseAtribute.Geburtsdatum;
import de.openknowledge.lehrer.Lehrer;
import de.openknowledge.lehrer.LehrerList;
import de.openknowledge.lehrer.Serveces.BereitendeLehrer;
import de.openknowledge.person.Person;

public class LeherService {
    private LehrerList lehrerList;

    public LeherService() {
        lehrerList = new LehrerList();
        BereitendeLehrer bereitendeLehrer = new BereitendeLehrer();
        for (Person person: bereitendeLehrer.getlehrer()){
            lehrerList.addPerson(person);
        }
    }
    public void addNeuLehrer(Name vorname, Name nachmame, Geburtsdatum geburtsdatum,
                             Telefon telefon, Adresse adresse, String lehrerNummer) {
        Lehrer lehrer = new Lehrer(vorname, nachmame, geburtsdatum, telefon, adresse, lehrerNummer);
        lehrerList.addPerson(lehrer);
    }
    public void removeLehrer(String lehrerNummer) {
        lehrerList.removeLehrerDurchLehrerNum(lehrerNummer);
    }
    public void removeLehrer(Lehrer lehrer) {
        lehrerList.removerPerson(lehrer);
    }

    public LehrerList getLehrerList() {
        return lehrerList;
    }
}
