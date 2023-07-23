package de.openknowledge.attribute.adresseAtribute;
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

import de.openknowledge.validieren.Validieren;

import java.util.Objects;

public class Hausnummer {
    private final String hausnummer;
    public Hausnummer(String hausnummer) {
        this.hausnummer = Validieren.eingegebeneWertValidieren("[\\w\\d\\s\\-/()\\.]+", hausnummer);
    }

    public String getHausnummer() {
        return hausnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hausnummer that = (Hausnummer) o;
        return Objects.equals(getHausnummer(), that.getHausnummer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHausnummer());
    }

    @Override
    public String toString() {
        return hausnummer;
    }
}
