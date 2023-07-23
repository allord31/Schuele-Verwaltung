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
package de.openknowledge.gui;

import de.openknowledge.attribute.Adresse;
import de.openknowledge.attribute.Name;
import de.openknowledge.attribute.Telefon;
import de.openknowledge.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.attribute.adresseAtribute.Geburtsdatum;
import de.openknowledge.attribute.adresseAtribute.Hausnummer;
import de.openknowledge.attribute.adresseAtribute.Plz;
import de.openknowledge.attribute.adresseAtribute.Stadt;
import de.openknowledge.attribute.adresseAtribute.Strasse;
import de.openknowledge.lehrer.Lehrer;
import de.openknowledge.lehrer.LehrerList;
import de.openknowledge.person.Person;
import de.openknowledge.schueler.Schueler;
import de.openknowledge.schueler.SchuelerList;

public class Main {
    public static void main(String[] args) {
        Lehrer lehrerOne = new Lehrer(new Name("Ahamd"), new Name("Alwardy"),
            new Geburtsdatum("1991-06-01"), new Telefon("123156231"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26122"),
                new Strasse("Moltke Str."), new Hausnummer("4/5")), "123412341234");

        Lehrer lehrerTow = new Lehrer(new Name("Housamm"), new Name("Alwardy"),
            new Geburtsdatum("1994-04-08"), new Telefon("123222-222"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Magdeburg"), new Plz("35152"),
                new Strasse("burger Str."), new Hausnummer("45")), "123412341235");

        Lehrer lehrerThree = new Lehrer(new Name("Hakam"), new Name("Alwardy"),
            new Geburtsdatum("1979-08-08"), new Telefon("123333-333-333"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26123"),
                new Strasse("Norder Str."), new Hausnummer("13")), "123412341236");

        LehrerList lehrerList = new LehrerList();
        lehrerList.addPerson(lehrerOne);
        lehrerList.addPerson(lehrerTow);
        lehrerList.addPerson(lehrerThree);
        for (Person person: lehrerList.getLehrerList()){
            System.out.println(person);
        }

        Schueler schuelerOne = new Schueler(new Name("Kassem"), new Name("Alwardy"),
            new Geburtsdatum("2010-08-10"), new Telefon("123222-111"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Alexander Str."), new Hausnummer("262")), "123412341231");

        Schueler schuelerTow = new Schueler(new Name("Saif"), new Name("Alwardy"),
            new Geburtsdatum("2012-06-04"), new Telefon("123222-1112"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Alexander Str."), new Hausnummer("262")), "123412341232");

        Schueler schuelerThree = new Schueler(new Name("Maher"), new Name("Alwardy"),
            new Geburtsdatum("2012-06-18"), new Telefon("123222-1113"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Bunde"), new Plz("35152"),
                new Strasse("winkel Str."), new Hausnummer("24")), "123412341233");
        System.out.println("");
        SchuelerList schuelerList = new SchuelerList();
        schuelerList.addPerson(schuelerOne);
        schuelerList.addPerson(schuelerTow);
        schuelerList.addPerson(schuelerThree);
        for (Person person : schuelerList.getSchuelerList()) {
            System.out.println(person);
        }
    }
}