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

import de.openknowledge.domain.verwaltung.attribute.Adresse;
import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Plz;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Stadt;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.domain.verwaltung.attribute.AdressenList;
import de.openknowledge.domain.verwaltung.attribute.Telefon;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.domain.verwaltung.attribute.Geburtsdatum;
import de.openknowledge.infrastruktur.exception.UngueltigeEingabe;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BereitendeLehrer {
    private ArrayList<Lehrer> lehrerArrayList = new ArrayList<>();
    public BereitendeLehrer() {
        try {
            Lehrer lehrerOne = new Lehrer(new Name("Brejet"), new Name("Bruns"),
                new Geburtsdatum("1991-06-01"), new Telefon("049176251 2253"),
                new AdressenList(new Adresse(new AdresszeileEins("Bahnhof Sud. 12"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26125"))), new LehrerNummer("123412341234"));

            Lehrer lehrerTow = new Lehrer(new Name("Sandra"), new Name("Lamping"),
                new Geburtsdatum("1994-04-08"), new Telefon("017565245523"),
                new AdressenList(new Adresse(new AdresszeileEins("Hinderk Str. 33"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26129"))), new LehrerNummer("123412341235"));

            Lehrer lehrerThree = new Lehrer(new Name("Tim"), new Name("Hoerstbrock"),
                new Geburtsdatum("1984-05-08"),
                new Telefon("0162/7585562"),
                new AdressenList(new Adresse(new AdresszeileEins("Oldenburg 13"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26133"))), new LehrerNummer("123412341236"));
            Lehrer lehrerfour = new Lehrer(new Name("Elke"), new Name("Bruemer"),
                new Geburtsdatum("1965-06-22"),
                new Telefon("049 168 277 5323"),
                new AdressenList(new Adresse(new AdresszeileEins("Einstein weg 4/5"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26122"))),new LehrerNummer("123412341234") );

            Lehrer lehrerfive = new Lehrer(new Name("Zilles"), new Name("Markus"),
                new Geburtsdatum("1977-01-24"), new Telefon("0152/766 2553"),
                new AdressenList(new Adresse(new AdresszeileEins("Saarlaender weg 45"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26124"))), new LehrerNummer("123412341235"));

            Lehrer lehrersix = new Lehrer(new Name("Wilfried"), new Name("Mull"),
                new Geburtsdatum("1967-11-15"),
                new Telefon("0491(587 215 563)"),
                new AdressenList(new Adresse(new AdresszeileEins("Sonnenallee 9"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26123"))), new LehrerNummer("123412341236"));
            Lehrer lehrerseven = new Lehrer(new Name("Harms"), new Name("Knut"),
                new Geburtsdatum("1969-02-11"),
                new Telefon("123-156(231)"),
                new AdressenList(new Adresse(new AdresszeileEins("Garten Str. 72"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26125"))), new LehrerNummer("123412341234"));

            Lehrer lehrereght = new Lehrer(new Name("Meschael"), new Name("Kuper"),
                new Geburtsdatum("1974-04-08"),
                new Telefon("123222-222"),
                new AdressenList(new Adresse(new AdresszeileEins("Winkel Str. 16"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26131"))), new LehrerNummer("123412341235"));

            Lehrer lehrerneun = new Lehrer(new Name("zer loy"), new Name("Hertz"),
                new Geburtsdatum("1987-08-08"),
                new Telefon("123333-333-333"),
                new AdressenList(new Adresse(new AdresszeileEins("Norder Str. 18"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26123"))), new LehrerNummer("123412341236"));
            lehrerArrayList.add(lehrerOne);
            lehrerArrayList.add(lehrerTow);
            lehrerArrayList.add(lehrerThree);
            lehrerArrayList.add(lehrerfour);
            lehrerArrayList.add(lehrerfive);
            lehrerArrayList.add(lehrersix);
            lehrerArrayList.add(lehrerseven);
            lehrerArrayList.add(lehrereght);
            lehrerArrayList.add(lehrerneun);
        } catch (UngueltigeEingabe ungueltigeEingabe) {
            MyBufferedReader.print(ungueltigeEingabe.getMessage());
        }


    }
    public ArrayList<Lehrer> getlehrer() {
        return lehrerArrayList;
    }
}
