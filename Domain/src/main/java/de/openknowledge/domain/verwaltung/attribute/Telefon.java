package de.openknowledge.domain.verwaltung.attribute;/*
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

import de.openknowledge.infrastruktur.exception.UngueltigeEingabe;
import de.openknowledge.infrastruktur.validieren.Validieren;

import java.util.Objects;

public class Telefon {
    private final String telefon;
    public Telefon(String telefon) throws UngueltigeEingabe {
        this.telefon  = Validieren.normierung("\\d",
            Validieren.eingegebeneWertValidieren("[\\d\\s()/-]+", telefon));
    }

    public String getTelefon() {
        return telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Telefon telefonOne = (Telefon) o;
        return Objects.equals(getTelefon(), telefonOne.getTelefon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTelefon());
    }

    @Override
    public String toString() {
        return telefon;
    }
}
