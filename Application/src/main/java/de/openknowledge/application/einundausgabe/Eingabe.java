package de.openknowledge.application.einundausgabe;
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

import de.openknowledge.domain.verwaltung.attribute.Geburtsdatum;
import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.attribute.Telefon;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Stadt;
import de.openknowledge.infrastruktur.exception.UngueltigeEingabe;
import de.openknowledge.infrastruktur.validieren.Validieren;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Plz;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;
import java.util.Scanner;



public class Eingabe {
   private static Scanner input = new Scanner(System.in);
    public static Integer auswahl(Integer anfangReichweit, Integer endeReichweit) {
        try {
            Integer eingabe =Integer.parseInt(Validieren.eingegebeneWertValidieren("\\d+",input.nextLine()));
            if (eingabe >= anfangReichweit && eingabe <= endeReichweit) {
                return eingabe;
            } else {
                MyBufferedReader.print("Sie müssen zwischen " + anfangReichweit+ " und " + endeReichweit + " auswählen.");
                return auswahl(anfangReichweit, endeReichweit);
            }
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(String.valueOf(eingabe));
           return auswahl(anfangReichweit,endeReichweit);
        }
    }
    public static Plz plz() {
        MyBufferedReader.print("Geben Sie die Postleitzahl ein: ");
        try {
            return new Plz(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "\n PLZ muss aus 5 Ziffern 0-9 bestehen.");
            return plz();
        }
    }
    public static Geburtsdatum geburtsdatum() {
        MyBufferedReader.print("Geben Sie das Geburtsdatum ein: ");
        try {
            return new Geburtsdatum(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "Das Geburtsdatum muss dieses Format haben: \"JJJJ-MM-TT || 2000-12-31\"");
            return geburtsdatum();
        }
    }
    public static AdresszeileEins adresszeileEins() {
        MyBufferedReader.print("Geben Sie die Adresse Zeile Eins ein: ");
        try {
            return new AdresszeileEins(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "Adresszeile besteht aus mindestens 1 und höchstens 80 Zeichen");
            return adresszeileEins();
        }
    }
    public static AdresszeileZwei adresszeileZwei() {
        MyBufferedReader.print("Geben Sie die Adresse Zeile Zwei ein: ");
        try {
            return new AdresszeileZwei(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "Adresszeile besteht aus mindestens 1 und höchstens 80 Zeichen");
            return adresszeileZwei();
        }
    }
    public static Name vorname() {
        MyBufferedReader.print("Geben Sie den vorname ein: ");
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "Der Vorname wird nur akzeptiert," +
                " wenn der aus Buchstaben besteht, und aus mindestens 1 und höchstens 50 Zeichen.");
            return vorname();
        }
    }
    public static Name nachname() {
        MyBufferedReader.print("Geben Sie den nachname ein: ");
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "Der Nachname wird nur akzeptiert," +
                " wenn der aus Buchstaben besteht, und aus mindestens 1 bis 50 Buchstabe.");
            return nachname();
        }
    }
    public static Name klassenName() {
        MyBufferedReader.print("Geben Sie den Klassenname ein: ");
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "Der Klassenname wird nur akzeptiert," +
                " wenn der aus Buchstaben besteht, und aus mindestens 1 bis 50 Buchstabe.");
            return klassenName();
        }
    }

    public static Telefon telefon() {
        MyBufferedReader.print("Geben Sie die Telefon Nummer ein: ");
        try {
            return new Telefon(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage());
            return telefon();
        }

    }
    public static Stadt stadt() {
        MyBufferedReader.print("Geben Sie die Stadt ein: ");
        try {
            return new Stadt(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "\nStat besteht aus mindestens 1 und höchstens 50 Zeichen");
            return stadt();
        }
    }
    public static LehrerNummer lehrerNummer() {
        MyBufferedReader.print("Geben Sie die lehrer Nummer ein: ");
        try {
            return new LehrerNummer(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "\n Lehrernummer ist genau 12 Zeichen lang und besteht aus Großbuchstaben und Ziffern");
            return lehrerNummer();
        }
    }
    public static SchuelerNummer schuelerNummer() {
        MyBufferedReader.print("Geben Sie die lehrer Nummer ein: ");
        try {
            return new SchuelerNummer(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage() + "\n Schülernummer ist genau 12 Zeichen lang und besteht aus Großbuchstaben und Ziffern");
            return schuelerNummer();
        }
    }
}
