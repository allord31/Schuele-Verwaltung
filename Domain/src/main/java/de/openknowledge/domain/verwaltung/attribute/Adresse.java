package de.openknowledge.domain.verwaltung.attribute;
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

import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Plz;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Stadt;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileZwei;

import java.util.Objects;

public class Adresse {
    private Stadt stadt;
    private Plz plz;
    private AdresszeileEins adresszeileEins;
    private AdresszeileZwei adresszeileZwei;

    public Adresse() {
    }

    public Adresse(AdresszeileEins adresszeileEins,AdresszeileZwei adresszeileZwei,
                   Stadt stadt, Plz plz) {
        this.adresszeileEins = adresszeileEins;
        this.adresszeileZwei = adresszeileZwei;
        this.stadt = stadt;
        this.plz = plz;

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
            Objects.equals(getAdresszeileEins(), adresse.getAdresszeileEins()) &&
            Objects.equals(getAdresszeileZwei(), adresse.getAdresszeileZwei());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStadt(), getPlz(), getAdresszeileEins(), getAdresszeileZwei());
    }

    @Override
    public String toString() {
        return "Adresse{" +
            "stadt=" + stadt +
            ", plz=" + plz +
            ", adresszeileEins=" + adresszeileEins +
            ", adresszeileZwei=" + adresszeileZwei +
            '}';
    }
}
