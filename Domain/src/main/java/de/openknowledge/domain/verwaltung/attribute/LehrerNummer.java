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

public class LehrerNummer {
   private String lehrerNummer;
    public LehrerNummer(String lehrerNummer) throws UngueltigeEingabe {
        this.lehrerNummer = Validieren.eingegebeneWertValidieren("[A-Z\\d]{12}", lehrerNummer);;
    }

    public String getLehrerNummer() {
        return lehrerNummer;
    }

    public void setLehrerNummer(String lehrerNummer) {
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
        LehrerNummer that = (LehrerNummer) o;
        return Objects.equals(getLehrerNummer(), that.getLehrerNummer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLehrerNummer());
    }

    @Override
    public String toString() {
        return "LehrerNummer{" +
            "lehrerNummer='" + lehrerNummer + '\'' +
            '}';
    }
}
