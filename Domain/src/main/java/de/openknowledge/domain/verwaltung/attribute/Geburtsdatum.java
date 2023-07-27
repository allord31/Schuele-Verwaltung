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
package de.openknowledge.domain.verwaltung.attribute;

import de.openknowledge.infrastruktur.printing.MyBufferedReader;
import de.openknowledge.infrastruktur.validieren.Validieren;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Geburtsdatum {
    private final LocalDate geburtsdatum;
    public Geburtsdatum(String dd_MM_yyyy) {
        this.geburtsdatum = validierteGeburtsdatum(dd_MM_yyyy);

    }

    private LocalDate validierteGeburtsdatum(String dd_MM_yyyy) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String datePattern = Validieren.eingegebeneWertValidieren("\\d{4}\\-\\d{2}\\-\\d{2}", dd_MM_yyyy);
        LocalDate localDate = LocalDate.now();
        if (LocalDate.parse(datePattern, formatter).getYear() + 5 >= localDate.getYear()) {
            MyBufferedReader.print("der schüler muss mindesten 6 Jahre alt sein.");
            Scanner input = new Scanner(System.in);
           return validierteGeburtsdatum(Validieren.eingegebeneWertValidieren("\\d{4}\\-\\d{2}\\-\\d{2}", input.nextLine()));
        }
        else {
            return LocalDate.parse(datePattern, formatter);
        }
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Geburtsdatum that = (Geburtsdatum) o;
        return Objects.equals(getGeburtsdatum(), that.getGeburtsdatum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGeburtsdatum());
    }

    @Override
    public String toString() {
        return "Geburtsdatum{" +
            "geburtsdatum=" + geburtsdatum +
            '}';
    }
}
