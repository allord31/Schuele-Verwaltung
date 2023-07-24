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
package de.openknowledge.schueler;

import de.openknowledge.attribute.Adresse;
import de.openknowledge.attribute.Name;
import de.openknowledge.attribute.Telefon;
import de.openknowledge.attribute.adresseAtribute.Geburtsdatum;
import de.openknowledge.person.Person;
import de.openknowledge.validieren.Validieren;

public class Schueler extends Person {
    private String schuelerNummer;

    public Schueler(){
        super();
    }

    public Schueler(Name vorname, Name nachmame, Geburtsdatum geburtsdatum, Telefon telefon, Adresse adresse, String schuelerNummer) {
        super(vorname, nachmame, geburtsdatum, telefon, adresse);
        this.schuelerNummer = Validieren.eingegebeneWertValidieren("[A-Z0-9]{12}", schuelerNummer);
    }

    public String getSchuelerNummer() {
        return schuelerNummer;
    }

    public void setSchuelerNummer(String schuelerNummer) {
        this.schuelerNummer = schuelerNummer;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + schuelerNummer +
            '}';
    }
}
