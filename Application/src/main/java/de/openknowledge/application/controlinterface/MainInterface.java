package de.openknowledge.application.controlinterface;
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

import de.openknowledge.infrastruktur.printing.MyBufferedReader;

public  class MainInterface {
    private static final String ZEIGEN_2_SCHUELER_LEHRER_KLASSE_SERVICES_3_4_5_6 = """
        1.zeigen
        2.Schüler, Lehrer in einer klasse umsetzen
        3.Neue Schüler oder Lehrer in der Schule einfügen.
        4.Schüler Oder Lehrer entfernen.
        5.
        6.beenden.
        """;
    private static final String WAS_UMSETZEN = """
        Was wollen Sie genau umsetzen ?
        1. Lehrer
        2. Schüler
        """;

    private static final String WAS_WOLLEN_SIE_ZEIGEN = """
        1. Alle klassen
        2. Alle Lehrer
        3. Alle Schüler
        4. Bestimmte Klass
        5. Bestimmte Lehrer
        6. Bestimmte Schüler
        7. Lehrer in bestimmte Klasse Zeigen.
        8. Schüler in bestimmte Klasse Zeigen.
        """;
    private static final String WAS_WOLLEN_SIE_ADDIEREN= """
        1.Lehrer
        2.Schüler
        """;
    private static final String WAS_WOLLEN_SIE_ENTFERNEN = """
        Was wollen Sie entfernen?
        1. Lehrer
        2. Schüler
        """;


    public static void mainInterfaceZeigen() {
        MyBufferedReader.print("\n"+ ZEIGEN_2_SCHUELER_LEHRER_KLASSE_SERVICES_3_4_5_6);
    }
    public static void wasWollenSieZeigen() {
        MyBufferedReader.print("\n" + WAS_WOLLEN_SIE_ZEIGEN);
    }
    public static void wasUmsetzen() {
        MyBufferedReader.print("\n" + WAS_UMSETZEN);
    }
    public static void wasAddieren() {
        MyBufferedReader.print("\n" + WAS_WOLLEN_SIE_ADDIEREN);
    }
    public static void wasEntfernen() {
        MyBufferedReader.print("\n" + WAS_WOLLEN_SIE_ENTFERNEN);
    }
}
