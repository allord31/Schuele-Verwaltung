package de.openknowledge.application.sekretearin;
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

import de.openknowledge.application.einundausgabe.Ausgabe;
import de.openknowledge.application.einundausgabe.Eingabe;
import de.openknowledge.application.guiservices.KopfVonServices;
import de.openknowledge.domain.verwaltung.Verwalten;
import de.openknowledge.domain.verwaltung.attribute.Adresse;
import de.openknowledge.domain.verwaltung.attribute.AdressenList;
import de.openknowledge.domain.verwaltung.attribute.Geburtsdatum;
import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.Telefon;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Plz;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Stadt;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.infrastruktur.exception.KeinPerson;
import de.openknowledge.infrastruktur.exception.KeineKlasse;
import de.openknowledge.infrastruktur.exception.PersonExist;
import de.openknowledge.infrastruktur.exception.PersonIstInDerKlasse;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

import org.apache.log4j.Logger;

public class LehrerController {
    private static final Logger log = Logger.getLogger(LehrerController.class.getName());
    private final Verwalten verwalten;
    /**
     * Konstruktor für den LehrerController.
     *
     * @param verwalten Das Verwaltungsobjekt, mit dem der Controller arbeitet.
     */
    public LehrerController(Verwalten verwalten) {
        this.verwalten = verwalten;
    }
    /**
     * Zeigt Details aller Lehrer an.
     */
    public void lehrerZeigen() {
        for (Lehrer lehrer : verwalten.getLehrerList()) {
            MyBufferedReader.print(Ausgabe.lehrerDetails().formatted(lehrer.getLehrerNummerObje().getLehrerNummer(), lehrer.getVorname()
                , lehrer.getNachname(), lehrer.getGeburtsdatum().toString(), lehrer.getAdresse().getAdresses(), lehrer.getTelefon()));
        }
        log.trace("lehrer List gezeigt.");
    }
    /**
     * Zeigt die Details eines bestimmten Lehrers an.
     *
     * @param lehrerNummer Die Nummer des gesuchten Lehrers.
     */
    public void bestimmteLehrerZeigen(LehrerNummer lehrerNummer) {
        for (Lehrer lehrer : verwalten.getLehrerList()) {
            if (lehrer.getLehrerNummerObje().equals(lehrerNummer)) {
                MyBufferedReader.print(Ausgabe.lehrerDetails().formatted(lehrer.getLehrerNummerObje().getLehrerNummer(), lehrer.getVorname()
                    , lehrer.getNachname(), lehrer.getGeburtsdatum().toString(), lehrer.getAdresse().getAdresses(), lehrer.getTelefon()));
                return;
            }
        }
        Ausgabe.lehrerNichtGefunden(lehrerNummer);
    }
    /**
     * Versetzt einen Lehrer in eine andere Klasse.
     */
    public void lehrerUmsetzen() {
        LehrerNummer lehrerNummer = Eingabe.lehrerNummer();
        Name klassenName = Eingabe.klassenName();
    try {
     verwalten.lehrerUmsetzen(klassenName,lehrerNummer);
     log.info("Lehrer wurde umgesetzt.");
    } catch (KeinPerson e) {
        Ausgabe.lehrerNichtGefunden(lehrerNummer);
    } catch (KeineKlasse e) {
        Ausgabe.klasseNichtGefunden(klassenName);
    }
    }
    /**
     * Fügt einen neuen Lehrer hinzu.
     */
    public void lehrerAddieren() {
        Lehrer neuLehrer = lehrerErstellen();
        try {
            verwalten.addNeuLehrer(neuLehrer);
            log.info("Lehrer wurde eingefügt.");
        } catch (PersonExist e) {
            Ausgabe.lehrerIstInDerSchuele(neuLehrer);
        }
    }
    /**
     * Erstellt ein Lehrer-Objekt mit den angegebenen Attributen.
     *
     * @return Ein neu erstelltes Lehrer-Objekt.
     */
    private static Lehrer lehrerErstellen() {
        log.info("Lehrer erstellen");
        LehrerNummer lehrerNummer= Eingabe.lehrerNummer();
        Name vorname = Eingabe.vorname();
        Name nachname = Eingabe.nachname();
        Geburtsdatum geburtsdatum = Eingabe.geburtsdatum();
        Telefon telefon = Eingabe.telefon();
        AdresszeileEins adresszeileEins = Eingabe.adresszeileEins();
        AdresszeileZwei adresszeileZwei = Eingabe.adresszeileZwei();
        Plz plz = Eingabe.plz();
        Stadt stadt = Eingabe.stadt();
        Adresse adresse = new Adresse(adresszeileEins, adresszeileZwei, stadt, plz);
        AdressenList adressenList = new AdressenList(adresse);
        Lehrer neuLehrer = new Lehrer(vorname, nachname, geburtsdatum, telefon, adressenList, lehrerNummer);
        log.info("Lehrer wurde erstellt.");
        return neuLehrer;
    }
    /**
     * Entfernt einen Lehrer.
     */
    public void lehrerEntfernen() {
        LehrerNummer lehrerNummer = Eingabe.lehrerNummer();
        try {
            verwalten.removeLehrer(lehrerNummer);
            log.info("Lehrer wurde Entfernt.");
        } catch (KeinPerson keinPerson) {
            Ausgabe.lehrerEntfernen(lehrerNummer);
        }
    }
}
