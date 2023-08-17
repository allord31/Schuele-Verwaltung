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

import org.apache.log4j.Logger;


public class Eingabe {
    private static Logger log = Logger.getLogger(Eingabe.class.getName());
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
                MyBufferedReader.print(resourceBundle.getString("AuswahlReichweite").formatted(anfangReichweite, endeReichweite));
                return auswahl(anfangReichweite, endeReichweite);
            }
        } catch (UngueltigeEingabe eingabe) {
           log.warn("Der Benutzer hat falsche Eingabe eingegeben.");
           return auswahl(anfangReichweite,endeReichweite);
        }
    }
    public static Plz plz() {
        MyBufferedReader.print(resourceBundle.getString("Eingabe_PLZ"));
        try {
            return new Plz(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigePLZ"));
            log.warn("Der Benutzer hat ungültige Post Leitzahl eingegeben.");
            return plz();
        }
    }
    public static Geburtsdatum geburtsdatum() {
        MyBufferedReader.print(resourceBundle.getString("EingabeGeburtsdatum"));
        try {
            return new Geburtsdatum(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeGeburtsdatum"));
            log.warn("Der Benutzer hat ungültige Geburtsdatum eingegeben.");
            return geburtsdatum();
        }
    }
    public static AdresszeileEins adresszeileEins() {
        MyBufferedReader.print(resourceBundle.getString("EingabeAdresszeileEins"));
        try {
            return new AdresszeileEins(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeAdresszeileEins"));
            log.warn("Der Benutzer hat ungültige AdresszeileEins eingegeben.");
            return adresszeileEins();
        }
    }
    public static AdresszeileZwei adresszeileZwei() {
        MyBufferedReader.print(resourceBundle.getString("EingabeAdresszeileZwei"));
        try {
            return new AdresszeileZwei(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeAdresszeileZwei"));
            log.warn("Der Benutzer hat ungültige AdresszeileZwei eingegeben.");
            return adresszeileZwei();
        }
    }
    public static Name vorname() {
        MyBufferedReader.print(resourceBundle.getString("EingabeVorname"));
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeVorname"));
            log.warn("Der Benutzer hat ungültige Vorname eingegeben.");
            return vorname();
        }
    }
    public static Name nachname() {
        MyBufferedReader.print(resourceBundle.getString("EingabeNachname"));
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeNachname"));
            log.warn("Der Benutzer hat ungültige Nachname eingegeben.");
            return nachname();
        }
    }
    public static Name klassenName() {
        MyBufferedReader.print(resourceBundle.getString("EingabeKlassenname"));
        try {
            return new Name(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeKlassenname"));
            log.warn("Der Benutzer hat ungültige Klassenname eingegeben.");
            return klassenName();
        }
    }

    public static Telefon telefon() {
        MyBufferedReader.print(resourceBundle.getString("EingabeTelefon"));
        try {
            return new Telefon(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeTelefon"));
            log.warn("Der Benutzer hat ungültige Telefonnummer eingegeben.");
            return telefon();
        }

    }
    public static Stadt stadt() {
        MyBufferedReader.print(resourceBundle.getString("EingabeStadt"));
        try {
            return new Stadt(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeStadt"));
            log.warn("Der Benutzer hat ungültige Stadt eingegeben.");
            return stadt();
        }
    }
    public static LehrerNummer lehrerNummer() {
        MyBufferedReader.print(resourceBundle.getString("EingabeLehrerNummer"));
        try {
            return new LehrerNummer(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeLehrerNummer"));
            log.warn("Der Benutzer hat ungültige Lehrernummer eingegeben.");
            return lehrerNummer();
        }
    }
    public static SchuelerNummer schuelerNummer() {
        MyBufferedReader.print(resourceBundle.getString("EingabeSchuelerNummer"));
        try {
            return new SchuelerNummer(input.nextLine());
        } catch (UngueltigeEingabe eingabe) {
            MyBufferedReader.print(resourceBundle.getString("UngueltigeSchuelerNummer"));
            log.warn("Der Benutzer hat ungültige Schülernummer eingegeben.");
            return schuelerNummer();
        }
    }
}
