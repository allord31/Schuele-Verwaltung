package de.openknowledge.lehrer.data;/*
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
import de.openknowledge.attribute.AdressenList;
import de.openknowledge.attribute.Name;
import de.openknowledge.attribute.Telefon;
import de.openknowledge.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.attribute.Geburtsdatum;
import de.openknowledge.attribute.adresseAtribute.Hausnummer;
import de.openknowledge.attribute.adresseAtribute.Plz;
import de.openknowledge.attribute.adresseAtribute.Stadt;
import de.openknowledge.attribute.adresseAtribute.Strasse;
import de.openknowledge.lehrer.Lehrer;


import java.util.ArrayList;

public class BereitendeLehrer {
    ArrayList<Lehrer> lehrerArrayList = new ArrayList<>();
    public ArrayList<Lehrer> getlehrer() {
        Lehrer lehrerOne = new Lehrer(new Name("Brejet"), new Name("Bruns"),
            new Geburtsdatum("1991-06-01"), new Telefon("049176251 2253"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26125"),
                new Strasse("Bahnhof Sud."), new Hausnummer("12"))), "123412341234");

        Lehrer lehrerTow = new Lehrer(new Name("Sandra"), new Name("Lamping"),
            new Geburtsdatum("1994-04-08"), new Telefon("017565245523"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26129"),
                new Strasse("Hinderk Str."), new Hausnummer("33"))), "123412341235");

        Lehrer lehrerThree = new Lehrer(new Name("Tim"), new Name("Hoerstbrock"),
            new Geburtsdatum("1984-05-08"), new Telefon("0162/7585562"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26133"),
                new Strasse("Haupt Strasse"), new Hausnummer("13"))), "123412341236");
        Lehrer lehrerfour = new Lehrer(new Name("Elke"), new Name("Bruemer"),
            new Geburtsdatum("1965-06-22"), new Telefon("049 168 277 5323"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26122"),
                new Strasse("Einstein weg"), new Hausnummer("4/5"))), "123412341234");

        Lehrer lehrerfive = new Lehrer(new Name("Zilles"), new Name("Markus"),
            new Geburtsdatum("1977-01-24"), new Telefon("0152/766 2553"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26124"),
                new Strasse("Saarlaender weg"), new Hausnummer("45"))), "123412341235");

        Lehrer lehrersix = new Lehrer(new Name("Wilfried"), new Name("Mull"),
            new Geburtsdatum("1967-11-15"), new Telefon("0491(587 215 563)"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26123"),
                new Strasse("Sonnenallee"), new Hausnummer("9"))), "123412341236");
        Lehrer lehrerseven = new Lehrer(new Name("Harms"), new Name("Knut"),
            new Geburtsdatum("1969-02-11"), new Telefon("123-156(231)"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26125"),
                new Strasse("Garten Str."), new Hausnummer("72"))), "123412341234");

        Lehrer lehrereght = new Lehrer(new Name("Meschael"), new Name("Kuper"),
            new Geburtsdatum("1974-04-08"), new Telefon("123222-222"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26131"),
                new Strasse("Winkel Str."), new Hausnummer("16"))), "123412341235");

        Lehrer lehrerneun = new Lehrer(new Name("zer loy"), new Name("Hertz"),
            new Geburtsdatum("1987-08-08"), new Telefon("123333-333-333"),
            new AdressenList(new Adresse(new AdresszeileEins("Germany in Niedersachsen"), new AdresszeileZwei(""),
                new Stadt("Oldenburg"), new Plz("26123"),
                new Strasse("Norder Str."), new Hausnummer("18"))), "123412341236");
        lehrerArrayList.add(lehrerOne);
        lehrerArrayList.add(lehrerTow);
        lehrerArrayList.add(lehrerThree);
        lehrerArrayList.add(lehrerfour);
        lehrerArrayList.add(lehrerfive);
        lehrerArrayList.add(lehrersix);
        lehrerArrayList.add(lehrerseven);
        lehrerArrayList.add(lehrereght);
        lehrerArrayList.add(lehrerneun);
        return lehrerArrayList;
    }
}
