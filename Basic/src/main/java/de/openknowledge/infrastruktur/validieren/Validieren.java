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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class Validieren {
    private static Logger log = Logger.getLogger(Validieren.class.getName());
    /**
     * Überprüft den Text auf Gültigkeit und gleicht ihn mit dem angegebenen regulären Ausdruck ab.
     *
     * @param regex Der reguläre Ausdruck, mit dem der Text abgeglichen wird.
     * @param zeichen Der Text, der auf Gültigkeit und Übereinstimmung mit dem regulären Ausdruck überprüft wird.
     * @return Der Text, wenn er erfolgreich mit dem regulären Ausdruck übereinstimmt.
     * @throws UngueltigeEingabe Wenn der Text nicht mit dem regulären Ausdruck übereinstimmt.
     */
    public static String eingegebeneWertValidieren(String regex, String zeichen) throws UngueltigeEingabe {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(zeichen);
            if (matcher.matches()){
                return zeichen;
            } else {
                log.warn("Der Benutzer hat ungültige Eingabe eingegeben.");
                throw new UngueltigeEingabe(zeichen);
            }
    }
    /**
     * Wendet den regulären Ausdruck auf den gegebenen Text an und extrahiert den passenden Text daraus.
     *
     * @param regex Der reguläre Ausdruck, der auf den Text angewendet werden soll.
     * @param zeichen Der Text, auf den der reguläre Ausdruck angewendet werden soll.
     * @return Der Text, der dem regulären Ausdruck im gegebenen Text entspricht.
     */
    public static String normierung(String regex, String zeichen) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zeichen);
        String normierteText = "";
        while (matcher.find()) {
            normierteText += matcher.group();
        }
        return normierteText;
    }
    public static String normierungErstesMatcher(String regex, String zeichen) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zeichen);
        matcher.find();
        return matcher.group();
        }
    }
