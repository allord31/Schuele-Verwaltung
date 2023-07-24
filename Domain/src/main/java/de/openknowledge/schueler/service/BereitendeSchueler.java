package de.openknowledge.schueler.service;/*
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
import de.openknowledge.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.attribute.adresseAtribute.Geburtsdatum;
import de.openknowledge.attribute.adresseAtribute.Hausnummer;
import de.openknowledge.attribute.adresseAtribute.Plz;
import de.openknowledge.attribute.adresseAtribute.Stadt;
import de.openknowledge.attribute.adresseAtribute.Strasse;
import de.openknowledge.person.Person;
import de.openknowledge.schueler.Schueler;
import de.openknowledge.schueler.SchuelerList;

import java.util.ArrayList;

public class BereitendeSchueler {
    public ArrayList<Person> getSchueler() {
        Schueler schuelerOne = new Schueler(new Name("Ahmad"), new Name("Alwardy"),
            new Geburtsdatum("1991-06-01"), new Telefon("162-713/2212"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Moltke Str."), new Hausnummer("4/5")), "123412341231");

        Schueler schuelerTow = new Schueler(new Name("Marjan"), new Name("Schneider"),
            new Geburtsdatum("1988-07-26"), new Telefon("124-255/2894"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Bremer Herr Str"), new Hausnummer("262")), "123412341232");

        Schueler schuelerThree = new Schueler(new Name("Jannis"), new Name("Brake"),
            new Geburtsdatum("1989-07-24"), new Telefon("168/215-3152"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Bunde"), new Plz("35152"),
                new Strasse("Garten Str."), new Hausnummer("24")), "123412341233");

        Schueler schuelerfour = new Schueler(new Name("Dennis"), new Name("Brumund"),
            new Geburtsdatum("1998-05-14"), new Telefon("173/212-3145"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Alexander Str."), new Hausnummer("262")), "123412341234");

        Schueler schuelerfive = new Schueler(new Name("Kristof"), new Name("Dalinghaus"),
            new Geburtsdatum("1992-02-05"), new Telefon("(173/212-4526))"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Nadorst"), new Hausnummer("262")), "123412341235");

        Schueler schuelersix = new Schueler(new Name("Tobias"), new Name("Ebben"),
            new Geburtsdatum("1998-01-15"), new Telefon("179/213-2130"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26112"),
                new Strasse("Haupt Strasse"), new Hausnummer("74")), "123412341236");

        Schueler schuelerseven = new Schueler(new Name("Alexander"), new Name("Gildenstern"),
            new Geburtsdatum("1998-04-13"), new Telefon("173-221/2114"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26203"),
                new Strasse("Augen str"), new Hausnummer("119")), "123412341237");

        Schueler schuelereght = new Schueler(new Name("Yousef"), new Name("Jamo"),
            new Geburtsdatum("1995-07-28"), new Telefon("167/212-1254"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26126"),
                new Strasse("Ofener Str"), new Hausnummer("42")), "123412341238");

        Schueler schuelernine = new Schueler(new Name("Mustafa"), new Name("Elias"),
            new Geburtsdatum("1989-09-08"), new Telefon("167-352/5263"),
            new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26127"),
                new Strasse("winkel Str."), new Hausnummer("312")), "123412341239");

        SchuelerList schuelerList = new SchuelerList();
        schuelerList.addPerson(schuelerOne);
        schuelerList.addPerson(schuelerTow);
        schuelerList.addPerson(schuelerThree);
        schuelerList.addPerson(schuelerfour);
        schuelerList.addPerson(schuelerfive);
        schuelerList.addPerson(schuelersix);
        schuelerList.addPerson(schuelerseven);
        schuelerList.addPerson(schuelereght);
        schuelerList.addPerson(schuelernine);
        return schuelerList.getSchuelerList();
    }
}
