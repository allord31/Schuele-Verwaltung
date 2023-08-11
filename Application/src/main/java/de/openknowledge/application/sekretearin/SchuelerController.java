package de.openknowledge.application.sekretearin;/*
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
import de.openknowledge.domain.verwaltung.Verwalten;
import de.openknowledge.domain.verwaltung.attribute.Adresse;
import de.openknowledge.domain.verwaltung.attribute.AdressenList;
import de.openknowledge.domain.verwaltung.attribute.Geburtsdatum;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.attribute.Telefon;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileEins;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.AdresszeileZwei;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Plz;
import de.openknowledge.domain.verwaltung.attribute.adresseAtribute.Stadt;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.exception.IstPersonInKlasse;
import de.openknowledge.infrastruktur.exception.KeinPerson;
import de.openknowledge.infrastruktur.exception.KeineKlasse;
import de.openknowledge.infrastruktur.exception.PersonExist;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

public class SchuelerController {
    private final Verwalten verwalten;
    /**
     * Konstruktor für den SchuelerController.
     *
     * @param verwalten Das Verwaltungsobjekt, mit dem der Controller arbeitet.
     */
    public SchuelerController(Verwalten verwalten) {
        this.verwalten = verwalten;
    }
    /**
     * Zeigt Details aller Schüler an.
     */
    public void schuelerZeigen() {
        for (Schueler schueler: verwalten.getSchuelerList()) {
            MyBufferedReader.print(Ausgabe.schuelerDetails().formatted(schueler.getSchuelerNummerObje().getSchulerNummer(),schueler.getVorname()
                ,schueler.getNachname(),schueler.getGeburtsdatum().toString(),schueler.getAdresse().getAdresses(), schueler.getTelefon()));
        }
    }
    /**
     * Zeigt Details eines bestimmten Schülers an.
     *
     * @param schuelerNummer Die Nummer des gesuchten Schülers.
     */
    public void bestimmteSchuelerZeigen(SchuelerNummer schuelerNummer) {
        for (Schueler schueler :verwalten.getSchuelerList()) {
            if (schueler.getSchuelerNummerObje().equals(schuelerNummer)) {
                MyBufferedReader.print(Ausgabe.schuelerDetails().formatted(schueler.getSchuelerNummerObje().getSchulerNummer(), schueler.getVorname()
                    , schueler.getNachname(), schueler.getGeburtsdatum().toString(), schueler.getAdresse().getAdresses(), schueler.getTelefon()));
                return;
            }
        }
        Ausgabe.schuelerNichtGefunden(schuelerNummer);
    }
    /**
     * Versetzt einen Schüler in eine andere Klasse.
     */
    public void schuelerUmsetzen() {
        SchuelerNummer schuelerNummer = Eingabe.schuelerNummer();
        Name klassenName = Eingabe.klassenName();
        try {
            verwalten. schuelerUmsetzen(klassenName, schuelerNummer);
        } catch (KeinPerson e) {
            Ausgabe.schuelerNichtGefunden(schuelerNummer);
        } catch (KeineKlasse e) {
            Ausgabe.klasseNichtGefunden(klassenName);
        } catch (IstPersonInKlasse e) {
            Ausgabe.schuelerIstInDieseKlasse(klassenName,  schuelerNummer);
        }
    }
    /**
     * Fügt einen neuen Schüler hinzu.
     */
    public void schuelerAddieren() {
        Schueler neuSchueler = schuelerErstellen();
        try {
            verwalten.addNeuSchueler(neuSchueler);
        } catch (PersonExist e) {
            Ausgabe.schuelerIstInDerSchuele(neuSchueler);
        }
    }
    /**
     * Erstellt ein Schüler-Objekt mit den angegebenen Attributen.
     *
     * @return Ein neu erstelltes Schüler-Objekt.
     */
    private static Schueler schuelerErstellen() {
        SchuelerNummer schuelerNummer= Eingabe.schuelerNummer();
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
        return new Schueler(vorname, nachname, geburtsdatum, telefon, adressenList, schuelerNummer);
    }
    /**
     * Entfernt einen Schüler.
     */
    public void schuelerEntfernen() {
        SchuelerNummer schuelerNummer = Eingabe.schuelerNummer();
        try {
            verwalten.removeSchueler(schuelerNummer);
        } catch (KeinPerson e) {
            Ausgabe.schuelerEntfernen(schuelerNummer);
        }
    }
}
