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
package de.openknowledge.attribute.adresseAtribute;

import de.openknowledge.validieren.Validieren;

import java.util.Objects;

public class Strasse {
    private final String strasse;
    public Strasse(String strasse) {
        this.strasse = Validieren.eingegebeneWertValidieren("[A-Za-z\\s/()\\.\\-]{1,50}",strasse);
    }
    public String getStrasse(){
        return strasse;
    }
    @Override
    public String toString() {
        return strasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Strasse strasseOne = (Strasse) o;
        return Objects.equals(getStrasse(), strasseOne.getStrasse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrasse());
    }
}
