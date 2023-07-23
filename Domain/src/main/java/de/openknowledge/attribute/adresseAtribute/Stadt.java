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

import de.openknowledge.validieren.Validieren;

import java.util.Objects;

public class Stadt {
    private final String stadt;
    public Stadt(String stadt) {
        this.stadt = Validieren.eingegebeneWertValidieren("[A-Za-z\\s]{1,50}", stadt);
    }

    public String getStadt() {
        return stadt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stadt stadt1 = (Stadt) o;
        return Objects.equals(getStadt(), stadt1.getStadt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStadt());
    }

    @Override
    public String toString() {
        return stadt;
    }
}
