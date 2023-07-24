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
import de.openknowledge.person.Person;
import de.openknowledge.schueler.Schueler;
import de.openknowledge.schueler.SchuelerList;
import de.openknowledge.schueler.service.BereitendeSchueler;

public class SchuelerService {
    private SchuelerList schuelerList;

    public SchuelerService() {
        schuelerList = new SchuelerList();
        BereitendeSchueler bereitendeSchueler = new BereitendeSchueler();
        for (Person person: bereitendeSchueler.getSchueler()){
            schuelerList.addPerson(person);
        }
    }
    public void addNeuSchueler(Name vorname, Name nachmame, Geburtsdatum geburtsdatum,
                             Telefon telefon, Adresse adresse, String schuelerNummer) {
        Schueler schueler = new Schueler(vorname, nachmame, geburtsdatum, telefon, adresse, schuelerNummer);
        schuelerList.addPerson(schueler);
    }
    public void removeSchueler(String schuelerNummer) {
        schuelerList.removeSchuelerDurchSchulerNum(schuelerNummer);
    }
    public void removeSchueler(Schueler schueler) {
        schuelerList.removerPerson(schueler);
    }

    public SchuelerList getSchuelerList() {
        return schuelerList;
    }
}
