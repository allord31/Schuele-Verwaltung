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
package de.openknowledge.lehrer;

import de.openknowledge.attribute.Adresse;
import de.openknowledge.attribute.Name;
import de.openknowledge.attribute.Telefon;
import de.openknowledge.attribute.adresseAtribute.Geburtsdatum;
import de.openknowledge.person.Person;
import de.openknowledge.validieren.Validieren;

public class Lehrer extends Person {
    private String lehrerNummer;

    public Lehrer() {
        super();
    }

    public Lehrer(Name vorname, Name nachmame, Geburtsdatum geburtsdatum, Telefon telefon, Adresse adresse, String lehrerNummer) {
        super(vorname, nachmame, geburtsdatum, telefon, adresse);
        this.lehrerNummer = Validieren.eingegebeneWertValidieren("[A-Z0-9]{12}", lehrerNummer);
    }


    public String getLehrerNummer() {
        return lehrerNummer;
    }

    public void setLehrerNummer(String lehrerNummer) {
        this.lehrerNummer = Validieren.eingegebeneWertValidieren("[A-Z0-9]{12}", lehrerNummer);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + lehrerNummer + '}';
    }
}
