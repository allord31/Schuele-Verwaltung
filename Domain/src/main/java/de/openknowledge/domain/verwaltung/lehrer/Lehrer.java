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
package de.openknowledge.domain.verwaltung.lehrer;


import de.openknowledge.domain.verwaltung.attribute.AdressenList;
import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.Telefon;
import de.openknowledge.domain.verwaltung.attribute.Geburtsdatum;


import java.util.Objects;


public class Lehrer  {
    private Name vorname;
    private Name nachname;
    private Geburtsdatum geburtsdatum;
    private Telefon telefon;
    private AdressenList adresse;
    private LehrerNummer lehrerNummer;

    public Lehrer() {
    }

    public Lehrer(Name vorname, Name nachmame, Geburtsdatum geburtsdatum, Telefon telefon, AdressenList adresse, LehrerNummer lehrerNummer) {
        this.vorname = vorname;
        this.nachname = nachmame;
        this.geburtsdatum = geburtsdatum;
        this.telefon = telefon;
        this.adresse = adresse;
        this.lehrerNummer = lehrerNummer;
    }

    public Name getVorname() {
        return vorname;
    }

    public void setVorname(Name vorname) {
        this.vorname = vorname;
    }

    public Name getNachname() {
        return nachname;
    }

    public void setNachname(Name nachname) {
        this.nachname = nachname;
    }

    public Geburtsdatum getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Geburtsdatum geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public AdressenList getAdresse() {
        return adresse;
    }

    public void setAdresse(AdressenList adresse) {
        this.adresse = adresse;
    }

    public LehrerNummer getLehrerNummerObje() {
        return lehrerNummer;
    }

    public void setLehrerNummer(LehrerNummer lehrerNummer) {
        this.lehrerNummer = lehrerNummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lehrer lehrer = (Lehrer) o;
        return Objects.equals(getVorname(), lehrer.getVorname()) && Objects.equals(getNachname(), lehrer.getNachname()) &&
            Objects.equals(getGeburtsdatum(), lehrer.getGeburtsdatum()) &&
            Objects.equals(getTelefon(), lehrer.getTelefon()) && Objects.equals(getAdresse(), lehrer.getAdresse()) &&
            Objects.equals(getLehrerNummerObje(), lehrer.getLehrerNummerObje());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVorname(), getNachname(), getGeburtsdatum(), getTelefon(), getAdresse(), getLehrerNummerObje());
    }

    @Override
    public String toString() {
        return "Lehrer{" +
            "vorname=" + vorname +
            ", nachname=" + nachname +
            ", geburtsdatum=" + geburtsdatum +
            ", telefon=" + telefon +
            ", adresse=" + adresse +
            ", lehrerNummer=" + lehrerNummer +
            '}';
    }
}
