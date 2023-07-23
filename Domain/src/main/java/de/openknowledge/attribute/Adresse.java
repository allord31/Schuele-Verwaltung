package de.openknowledge.attribute;
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

import de.openknowledge.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.attribute.adresseAtribute.Hausnummer;
import de.openknowledge.attribute.adresseAtribute.Plz;
import de.openknowledge.attribute.adresseAtribute.Stadt;
import de.openknowledge.attribute.adresseAtribute.Strasse;

import java.util.Objects;

public class Adresse {
    private Stadt stadt;
    private Plz plz;
    private Strasse strasse;
    private Hausnummer hausnummer;
    private AdresszeileEins adresszeileEins;
    private AdresszeileZwei adresszeileZwei;

    public Adresse() {
    }

    public Adresse(AdresszeileEins adresszeileEins,AdresszeileZwei adresszeileZwei,
                   Stadt stadt, Plz plz, Strasse strasse, Hausnummer hausnummer) {
        this.adresszeileEins = adresszeileEins;
        this.adresszeileZwei = adresszeileZwei;
        this.stadt = stadt;
        this.plz = plz;
        this.strasse = strasse;
        this.hausnummer = hausnummer;

    }

    public AdresszeileEins getAdresszeileEins() {
        return adresszeileEins;
    }

    public void setAdresszeileEins(AdresszeileEins adresszeileEins) {
        this.adresszeileEins = adresszeileEins;
    }

    public AdresszeileZwei getAdresszeileZwei() {
        return adresszeileZwei;
    }

    public void setAdresszeileZwei(AdresszeileZwei adresszeileZwei) {
        this.adresszeileZwei = adresszeileZwei;
    }

    public Stadt getStadt() {
        return stadt;
    }

    public void setStadt(Stadt stadt) {
        this.stadt = stadt;
    }

    public Plz getPlz() {
        return plz;
    }

    public void setPlz(Plz plz) {
        this.plz = plz;
    }

    public Strasse getStrasse() {
        return strasse;
    }

    public void setStrasse(Strasse strasse) {
        this.strasse = strasse;
    }

    public Hausnummer getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(Hausnummer hausnummer) {
        this.hausnummer = hausnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Adresse adresse = (Adresse) o;
        return Objects.equals(getStadt(), adresse.getStadt()) && Objects.equals(getPlz(), adresse.getPlz()) &&
            Objects.equals(getStrasse(), adresse.getStrasse()) &&
            Objects.equals(getHausnummer(), adresse.getHausnummer()) &&
            Objects.equals(getAdresszeileEins(), adresse.getAdresszeileEins()) &&
            Objects.equals(getAdresszeileZwei(), adresse.getAdresszeileZwei());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStadt(), getPlz(), getStrasse(), getHausnummer(), getAdresszeileEins(), getAdresszeileZwei());
    }

    @Override
    public String toString() {
        return "Adresse{" +
            "stadt=" + stadt +
            ", plz=" + plz +
            ", strasse=" + strasse +
            ", hausnummer=" + hausnummer +
            ", adresszeileEins=" + adresszeileEins +
            ", adresszeileZwei=" + adresszeileZwei +
            '}';
    }
}
