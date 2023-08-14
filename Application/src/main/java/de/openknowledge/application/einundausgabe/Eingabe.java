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

import de.openknowledge.application.guiservices.KopfVonServices;
import de.openknowledge.application.guiservices.Sprachen;
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

import java.util.ResourceBundle;
import java.util.Scanner;



public class Eingabe {
    private static ResourceBundle resourceBundle = new Sprachen().getResourceBundle();
   private static Scanner input = new Scanner(System.in);
    public static void setResourceBundle(ResourceBundle setResourceBundle) {
        resourceBundle = setResourceBundle;
    }
    public static Integer auswahl(Integer anfangReichweite, Integer endeReichweite) {
        try {
            Integer eingabe =Integer.parseInt(Validieren.eingegebeneWertValidieren("\\d+",input.nextLine()));
            if (eingabe >= anfangReichweite && eingabe <= endeReichweite) {
                return eingabe;
            } else {
                MyBufferedReader.print(resourceBundle.getString("AuswahlReichweite"));
                return auswahl(anfangReichweite, endeReichweite);
            }
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeEingabe"));
           return auswahl(anfangReichweite,endeReichweite);
        }
    }
    public static Plz plz() {
        MyBufferedReader.print(resourceBundle.getString("Eingabe_PLZ"));
        try {
            return new Plz(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigePLZ"));
            return plz();
        }
    }
    public static Geburtsdatum geburtsdatum() {
        MyBufferedReader.print(resourceBundle.getString("EingabeGeburtsdatum"));
        try {
            return new Geburtsdatum(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeGeburtsdatum"));
            return geburtsdatum();
        }
    }
    public static AdresszeileEins adresszeileEins() {
        MyBufferedReader.print(resourceBundle.getString("EingabeAdresszeileEins"));
        try {
            return new AdresszeileEins(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeAdresszeileEins"));
            return adresszeileEins();
        }
    }
    public static AdresszeileZwei adresszeileZwei() {
        MyBufferedReader.print(resourceBundle.getString("EingabeAdresszeileZwei"));
        try {
            return new AdresszeileZwei(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeAdresszeileZwei"));
            return adresszeileZwei();
        }
    }
    public static Name vorname() {
        MyBufferedReader.print(resourceBundle.getString("EingabeVorname"));
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeVorname"));
            return vorname();
        }
    }
    public static Name nachname() {
        MyBufferedReader.print(resourceBundle.getString("EingabeNachname"));
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeNachname"));
            return nachname();
        }
    }
    public static Name klassenName() {
        MyBufferedReader.print(resourceBundle.getString("EingabeKlassenname"));
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeKlassenname"));
            return klassenName();
        }
    }

    public static Telefon telefon() {
        MyBufferedReader.print(resourceBundle.getString("EingabeTelefon"));
        try {
            return new Telefon(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(eingabe.getMessage());
            return telefon();
        }

    }
    public static Stadt stadt() {
        MyBufferedReader.print(resourceBundle.getString("EingabeStadt"));
        try {
            return new Stadt(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeStadt"));
            return stadt();
        }
    }
    public static LehrerNummer lehrerNummer() {
        MyBufferedReader.print(resourceBundle.getString("EingabeLehrerNummer"));
        try {
            return new LehrerNummer(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeLehrerNummer"));
            return lehrerNummer();
        }
    }
    public static SchuelerNummer schuelerNummer() {
        MyBufferedReader.print(resourceBundle.getString("EingabeSchuelerNummer"));
        try {
            return new SchuelerNummer(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeSchuelerNummer"));
            return schuelerNummer();
        }
    }
}
