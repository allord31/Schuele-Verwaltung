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

import java.util.ArrayList;

import de.openknowledge.domain.verwaltung.attribute.Adresse;
import de.openknowledge.domain.verwaltung.attribute.AdressenList;
import de.openknowledge.domain.verwaltung.attribute.Geburtsdatum;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.attribute.Telefon;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Plz;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Stadt;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.exception.UngueltigeEingabe;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

public class BereitendeSchueler {
    private ArrayList<Schueler> SchuelerArrayList = new ArrayList<>();

    public BereitendeSchueler() {
        try {
            Schueler schuelerOne = new Schueler(new Name("Ahmad"), new Name("Alwardy"),
                new Geburtsdatum("1991-06-01"),
                new Telefon("162-713/2212"),
                new AdressenList(new Adresse(new AdresszeileEins("Moltke Str. 4/5"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26133"))), new SchuelerNummer("123412341231"));

            Schueler schuelerTow = new Schueler(new Name("Marjan"), new Name("Schneider"),
                new Geburtsdatum("1988-07-26"),
                new Telefon("124-255/2894"),
                new AdressenList(new Adresse(new AdresszeileEins("Bremer Herr Str 262"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26133"))), new SchuelerNummer("123412341232"));

            Schueler schuelerThree = new Schueler(new Name("Jannis"), new Name("Brake"),
                new Geburtsdatum("1989-07-24"),
                new Telefon("168/215-3152"),
                new AdressenList(new Adresse(new AdresszeileEins("Garten Str. 24"), new AdresszeileZwei(""),
                    new Stadt("Bunde"), new Plz("35152"))), new SchuelerNummer("123412341233"));

            Schueler schuelerfour = new Schueler(new Name("Dennis"), new Name("Brumund"),
                new Geburtsdatum("1998-05-14"),
                new Telefon("173/212-3145"),
                new AdressenList(new Adresse(new AdresszeileEins("Alexander Str. 262"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26133"))), new SchuelerNummer("123412341234"));

            Schueler schuelerfive = new Schueler(new Name("Kristof"), new Name("Dalinghaus"),
                new Geburtsdatum("1992-02-05"),
                new Telefon("(173/212-4526))"),
                new AdressenList(new Adresse(new AdresszeileEins("Nadorst 25"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26133"))), new SchuelerNummer("123412341235"));

            Schueler schuelersix = new Schueler(new Name("Tobias"), new Name("Ebben"),
                new Geburtsdatum("1998-01-15"),
                new Telefon("179/213-2130"),
                new AdressenList(new Adresse(new AdresszeileEins("Haupt Strasse 74"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26112"))), new SchuelerNummer("123412341236"));

            Schueler schuelerseven = new Schueler(new Name("Alexander"), new Name("Gildenstern"),
                new Geburtsdatum("1998-04-13"),
                new Telefon("173-221/2114"),
                new AdressenList(new Adresse(new AdresszeileEins("Augen str 119"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26203"))), new SchuelerNummer("123412341237"));

            Schueler schuelereght = new Schueler(new Name("Yousef"), new Name("Jamo"),
                new Geburtsdatum("1995-07-28"),
                new Telefon("167/212-1254"),
                new AdressenList(new Adresse(new AdresszeileEins("Ofener Str 42"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26126"))), new SchuelerNummer("123412341238"));

            Schueler schuelernine = new Schueler(new Name("Mustafa"), new Name("Elias"),
                new Geburtsdatum("1989-09-08"),
                new Telefon("167-352/5263"),
                new AdressenList(new Adresse(new AdresszeileEins("winkel Str. 312"), new AdresszeileZwei(""),
                    new Stadt("Oldenburg"), new Plz("26127"))), new SchuelerNummer("123412341239"));

            SchuelerArrayList.add(schuelerOne);
            SchuelerArrayList.add(schuelerTow);
            SchuelerArrayList.add(schuelerThree);
            SchuelerArrayList.add(schuelerfour);
            SchuelerArrayList.add(schuelerfive);
            SchuelerArrayList.add(schuelersix);
            SchuelerArrayList.add(schuelerseven);
            SchuelerArrayList.add(schuelereght);
            SchuelerArrayList.add(schuelernine);

        } catch (UngueltigeEingabe ungueltigeEingabe) {
            MyBufferedReader.print(ungueltigeEingabe.getMessage());
        }


    }

    public ArrayList<Schueler> getSchueler() {
        return SchuelerArrayList;
    }

    public void setSchuelerArrayList(ArrayList<Schueler> schuelerArrayList) {
        this.SchuelerArrayList = schuelerArrayList;
    }
}
