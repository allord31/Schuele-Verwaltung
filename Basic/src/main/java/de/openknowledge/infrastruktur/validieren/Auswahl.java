package de.openknowledge.infrastruktur.validieren;/*
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
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

import java.util.Scanner;

public class Auswahl {
    public static int auswahl(int anfangReichweit, int endeReichweit) {
        Scanner input = new Scanner(System.in);
        int auswahl;
        try {
            MyBufferedReader.print("geben Sie Ihre Auswahl ein: ");
            auswahl = input.nextInt();
            if (auswahl >= anfangReichweit && auswahl <= endeReichweit) {
                return auswahl;
            } else {
                MyBufferedReader.print("Sie müssen Ziffern zwischen " + anfangReichweit + " und " + endeReichweit + " eingeben.");
                throw new UngueltigeEingabe(String.valueOf(auswahl));
            }
        } catch (UngueltigeEingabe e) {
            MyBufferedReader.print(e.getMessage());
            return auswahl(anfangReichweit, endeReichweit);
        }
    }

}
