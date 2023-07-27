package de.openknowledge.person;/*
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
import de.openknowledge.attribute.Geburtsdatum;

public class Person {
    private Name vorname;
    private Name nachname;
    private Geburtsdatum geburtsdatum;
    private Telefon telefon;
    private Adresse adresse;

    public Person() {
    }

    public Person(Name vorname, Name nachmame, Geburtsdatum geburtsdatum, Telefon telefon, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachmame;
        this.geburtsdatum = geburtsdatum;
        this.telefon = telefon;
        this.adresse = adresse;
    }

    public void setVorname(Name vorname) {
        this.vorname = vorname;
    }

    public void setNachname(Name nachname) {
        this.nachname = nachname;
    }

    public void setGeburtsdatum(Geburtsdatum geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Name getVorname() {
        return vorname;
    }

    public Name getNachname() {
        return nachname;
    }

    public Geburtsdatum getGeburtsdatum() {
        return geburtsdatum;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "Person{" +
            "vorname=" + vorname +
            ", nachname=" + nachname +
            ", geburtsdatum=" + geburtsdatum +
            ", telefon=" + telefon +
            ", adresse=" + adresse ;
    }
}
