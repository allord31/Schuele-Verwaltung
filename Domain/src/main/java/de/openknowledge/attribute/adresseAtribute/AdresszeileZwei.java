package de.openknowledge.attribute.adresseAtribute;/*
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

import java.util.Objects;

import de.openknowledge.validieren.Validieren;

public class AdresszeileZwei {
    private final String adresszeileZwei;
    public AdresszeileZwei(String adresszeileEins) {
        this.adresszeileZwei = Validieren.eingegebeneWertValidieren("[\\w\\W]{0,80}",adresszeileEins);
    }

    public String getAdresszeileZwei() {
        return adresszeileZwei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdresszeileZwei that = (AdresszeileZwei) o;
        return Objects.equals(getAdresszeileZwei(), that.getAdresszeileZwei());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdresszeileZwei());
    }

    @Override
    public String toString() {
        return adresszeileZwei;
    }
}
