package de.openknowledge.domain.verwaltung;/*
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.openknowledge.domain.verwaltung.attribute.LehrerNummer;
import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.attribute.SchuelerNummer;
import de.openknowledge.domain.verwaltung.klasse.Klasse;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.exception.KeinPerson;
import de.openknowledge.infrastruktur.exception.KeineKlasse;
import de.openknowledge.infrastruktur.exception.KlasseExist;
import de.openknowledge.infrastruktur.exception.PersonExist;

import org.apache.log4j.Logger;

public class Verwalten {
    static Logger log = Logger.getLogger(Verwalten.class.getName());
    private ArrayList<Klasse> klassenList = new ArrayList<>();
    private ArrayList<Schueler> schuelerList = new ArrayList<>();
    private ArrayList<Lehrer> lehrerList = new ArrayList<>();


    public Verwalten(ArrayList<Klasse> klassenList, ArrayList<Lehrer> lehrerList, ArrayList<Schueler> schuelerList) {
        this.klassenList.addAll(klassenList);
        this.lehrerList.addAll(lehrerList);
        this.schuelerList.addAll(schuelerList);
    }

    public void addNeuSchueler(Schueler schueler) throws PersonExist {
        if (schuelerList.contains(schueler)) {
            log.warn("Der Benutzer hat ein Schüler eingefügt, der schon in die schüler eingefügt würde.");
            throw new PersonExist(schueler.getSchuelerNummerObje().getSchulerNummer());
        } else {
            schuelerList.add(schueler);
        }
    }

    public void removeSchueler(SchuelerNummer schuelerNummer) throws KeinPerson {
        Schueler schueler = getSchueler(schuelerNummer);
            if (schuelerList.contains(schueler)) {
                schuelerList.remove(schueler);
                schuelerInKlasse(schuelerNummer).removeSchueler(schueler);
            } else {
                log.warn("Der Benutzer wollte ein Schüler entfernen, der schon nicht in die Schule existiert ist.");
                throw new KeinPerson(schueler.getSchuelerNummerObje().getSchulerNummer());
            }
    }

    public void addSchuelerInKlasse(Name klassenName, SchuelerNummer schuelerNummer) throws KeineKlasse, KeinPerson {
        if (getKlasse(klassenName) != null && getSchueler(schuelerNummer) != null && !istSchuelerDa(klassenName, schuelerNummer)) {
            getKlasse(klassenName).getSchuelers().add(getSchueler(schuelerNummer));
        }
    }

    public void removeSchuelerVonKlasse(Name klassenName, SchuelerNummer schuelerNummer) throws KeineKlasse, KeinPerson {
        if (getKlasse(klassenName) != null && getSchueler(schuelerNummer) != null && istSchuelerDa(klassenName, schuelerNummer)) {
            getKlasse(klassenName).getSchuelers().remove(getSchueler(schuelerNummer));
        }
    }

    public void schuelerUmsetzen(Name klassenName, SchuelerNummer schuelerNummer) throws KeineKlasse, KeinPerson{
        Klasse istSchuelerBereitInEinderKLasseGetKlasse = schuelerInKlasse(schuelerNummer);
        addSchuelerInKlasse(klassenName, schuelerNummer);
        if (istSchuelerBereitInEinderKLasseGetKlasse != null) {
            removeSchuelerVonKlasse(istSchuelerBereitInEinderKLasseGetKlasse.getName(), schuelerNummer);
        }
    }

    private Klasse schuelerInKlasse(SchuelerNummer schuelerNummer) throws KeinPerson {
        for (Klasse klasse : klassenList) {
            for (Schueler schueler : klasse.getSchuelers()) {
                if (schueler.getSchuelerNummerObje().equals(schuelerNummer)) {
                    return klasse;
                }
            }
        }
        log.warn("Diese Schüler ist nicht in den Klassen.");
        throw new KeinPerson(schuelerNummer.getSchulerNummer());
    }

    private boolean istSchuelerDa(Name klassenName, SchuelerNummer schuelerNummer) throws KeineKlasse {
        if (getKlasse(klassenName) != null) {
            for (Schueler schueler : getKlasse(klassenName).getSchuelers()) {
                if (schueler.getSchuelerNummerObje().equals(schuelerNummer)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Schueler getSchueler(SchuelerNummer schuelerNummer) throws KeinPerson {
        for (Schueler schueler : schuelerList) {
            if (schueler.getSchuelerNummerObje().equals(schuelerNummer)) {
                return schueler;
            }
        }
        log.warn("Der gesuchte Schüler ist nicht exist");
        throw new KeinPerson(schuelerNummer.getSchulerNummer());
    }

    public void addNueKlasse(Klasse klasse) throws KlasseExist {
        if (klassenList.contains(klasse)) {
            log.warn("Die eingefügte Klasse ist schon ein gefügt.");
            throw new KlasseExist(klasse.getName().getName());
        } else {
            klassenList.add(klasse);
        }
    }

    public void removeKlasse(Klasse klasse) throws KeineKlasse {
        if (klassenList.contains(klasse)) {
            klassenList.remove(klasse);
        } else {
            log.warn("Die Klasse ist nicht in die Schule existiert.");
            throw new KeineKlasse(klasse.getName().getName());
        }
    }

    private boolean istKlasseDa(Name klasseName) {
        for (Klasse klasse : klassenList) {
            if (klasse.getName().getName().equals(klasseName.getName())) {
                return true;
            }
        }
        return false;
    }

    public Klasse getKlasse(Name klassenName) throws KeineKlasse {
        for (Klasse klasse : klassenList) {
            if (klasse.getName().getName().equals(klassenName.getName())) {
                return klasse;
            }
        }
        log.warn("Die gesuchte Klasse ist nicht exist");
        throw new KeineKlasse(klassenName.getName());
    }

    public void addNeuLehrer(Lehrer lehrer) throws PersonExist {
        if (lehrerList.contains(lehrer)) {
            log.warn("Der Lehrer ist schon bereit in der Schule eingefügt worden.");
            throw new PersonExist(lehrer.getVorname() + " " + lehrer.getNachname());
        } else {
            lehrerList.add(lehrer);
        }
    }

    public void removeLehrer(LehrerNummer lehrerNummer) throws KeinPerson {
        try {
            Lehrer lehrer = getLehrer(lehrerNummer);
            if (lehrerList.contains(lehrer)) {
                lehrerList.remove(lehrer);
                if (lehrerInKlasse(lehrerNummer) != null) {
                    removeLehrerVonKlasse(lehrerInKlasse(lehrerNummer).getName(), lehrerNummer);
                }
            } else {
                log.warn("Der Lehrer ist nicht in der Schule.");
                throw new KeinPerson(lehrer.getLehrerNummerObje().getLehrerNummer());
            }
        } catch (KeineKlasse  e) {
            //da braucht man nichts zu machen, da es, wenn es kein lehrer in der Klasse gibt, dann bracht mann dieser Lehrer nicht zu entfernen
        }
    }

    public void addLehrerInKlasse(Name klassenName, LehrerNummer lehrerNummer) throws KeineKlasse, KeinPerson {
        if (getKlasse(klassenName) != null && getLehrer(lehrerNummer) != null && !istLehrerDa(klassenName, lehrerNummer)) {
            getKlasse(klassenName).addLehrer(getLehrer(lehrerNummer));
        }
    }

    public void removeLehrerVonKlasse(Name klassenName, LehrerNummer lehrerNummer) throws KeineKlasse, KeinPerson {
        if (getKlasse(klassenName) != null && getLehrer(lehrerNummer) != null && istLehrerDa(klassenName, lehrerNummer)) {
            getKlasse(klassenName).removeLehrer(getLehrer(lehrerNummer));
        }
    }

    public void lehrerUmsetzen(Name klassenName, LehrerNummer lehrerNummer) throws KeineKlasse, KeinPerson {
        Klasse istLehrerBereitInEinderKLasseGetKlasse = lehrerInKlasse(lehrerNummer);
        addLehrerInKlasse(klassenName, lehrerNummer);
        if (istLehrerBereitInEinderKLasseGetKlasse != null) {
            removeLehrerVonKlasse(istLehrerBereitInEinderKLasseGetKlasse.getName(), lehrerNummer);
        }
    }


    private Klasse lehrerInKlasse(LehrerNummer lehrerNummer) throws KeinPerson {
        for (Klasse klasse : klassenList) {
            for (Lehrer lehrer : klasse.getLehrers()) {
                if (lehrer.getLehrerNummerObje().getLehrerNummer().equals(lehrerNummer.getLehrerNummer())) {
                    return klasse;
                }
            }
        }
        log.warn("Der Lehrer ist nicht in der Klasse");
        throw new KeinPerson(lehrerNummer.getLehrerNummer());
    }

    private boolean istLehrerDa(Name klassenName, LehrerNummer lehrerNummer) throws KeineKlasse {
        if (getKlasse(klassenName) != null) {
            Klasse klasse = getKlasse(klassenName);
            for (Lehrer lehrer : klasse.getLehrers()) {
                if (lehrer.getLehrerNummerObje().equals(lehrerNummer)) {
                    return true;
                }
            }
            return false;
        }
        log.warn("Die ein gegebene Klass ist nicht gefunden.");
        throw new KeineKlasse(klassenName.getName());
    }

    public Lehrer getLehrer(LehrerNummer lehrerNummer) throws KeinPerson {
        for (Lehrer lehrer : lehrerList) {
            if (lehrer.getLehrerNummerObje().equals(lehrerNummer)) {
                return lehrer;
            }
        }
        log.warn("Die Lehrer ist nicht existiert");
        throw new KeinPerson(lehrerNummer.getLehrerNummer());
    }


    public List<Klasse> getKlassenList() {
        return Collections.unmodifiableList(klassenList);
    }

    public List<Lehrer> getLehrerList() {
        return Collections.unmodifiableList(lehrerList);
    }

    public List<Schueler> getSchuelerList() {
        return Collections.unmodifiableList(schuelerList);
    }

}

