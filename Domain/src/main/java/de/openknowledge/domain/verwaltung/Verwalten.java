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

import de.openknowledge.domain.verwaltung.klasse.Klasse;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.infrastruktur.exception.KeinPerson;
import de.openknowledge.infrastruktur.exception.KeineKlasse;
import de.openknowledge.infrastruktur.exception.KlasseExist;
import de.openknowledge.infrastruktur.exception.PersonExist;

public class Verwalten {
    private ArrayList<Klasse> klassenList = new ArrayList<>();
    private ArrayList<Schueler> schuelerList = new ArrayList<>();
    private ArrayList<Lehrer> lehrerList = new ArrayList<>();

    public Verwalten(ArrayList<Klasse> klassenList, ArrayList<Lehrer> lehrerList, ArrayList<Schueler> schuelerList) {
        this.klassenList.addAll(klassenList);
        this.lehrerList.addAll(lehrerList);
        this.schuelerList.addAll(schuelerList);
    }

    public Verwalten() {

    }

    public void addNeuSchueler(Schueler schueler) throws PersonExist {
        if (schuelerList.contains(schueler)) {
            throw new PersonExist(schueler.getSchuelerNummerObje().getSchulerNummer());
        } else {
            schuelerList.add(schueler);
        }
    }
    public void removExistSchueler(Schueler schueler) throws KeinPerson {
        if (schuelerList.contains(schueler)) {
            schuelerList.remove(schueler);
        } else {
            throw new KeinPerson(schueler.getSchuelerNummerObje().getSchulerNummer());
        }
    }
    public void addSchuelerInKlasse(String klassenName, String schuelerNummer) throws KeineKlasse, PersonExist, KeinPerson {
        if (getKlasse(klassenName) != null && getSchueler(schuelerNummer) != null && !istSchuelerDa(klassenName, schuelerNummer)) {
            getKlasse(klassenName).getSchuelers().add(getSchueler(schuelerNummer));
        }
    }
    public void removeSchuelerVonKlasse(String klassenName, String schuelerNummer) throws KeineKlasse, KeinPerson, PersonExist {
        if (getKlasse(klassenName) != null && getSchueler(schuelerNummer) != null && istSchuelerDa(klassenName,schuelerNummer)) {
            getKlasse(klassenName).getSchuelers().remove(getSchueler(schuelerNummer));
        }
    }
    private boolean istSchuelerDa(String klassenName, String schuelerNummer) throws KeineKlasse, PersonExist {
            if (getKlasse(klassenName) != null) {
                for (Schueler schueler: getKlasse(klassenName).getSchuelers()) {
                    if (schueler.getSchuelerNummerObje().getSchulerNummer().equals(schuelerNummer)){
                        return true;
                    }
                }
            } return false;
    }
    public Schueler getSchueler(String schuelerNummer) throws KeinPerson {
        for(Schueler schueler: schuelerList) {
            if (schueler.getSchuelerNummerObje().getSchulerNummer().equals(schuelerNummer)){
                return schueler;
            }
        }
        throw new KeinPerson(schuelerNummer);
    }

    public void addNueKlasse(Klasse klasse) throws KlasseExist {
        if (klassenList.contains(klasse)) {
            throw new KlasseExist(klasse.getName());
        } else {
            klassenList.add(klasse);
        }
    }
    public void removeKlasse(Klasse klasse) throws KeineKlasse {
        if (klassenList.contains(klasse)) {
            klassenList.remove(klasse);
        } else {
            throw new KeineKlasse(klasse.getName());
        }
    }
    private boolean istKlasseDa(String klasseName) {
        for (Klasse klasse:klassenList) {
            if (klasse.getName().equals(klasseName)) {
                return true;
            }
        }
        return false;
    }
    public Klasse getKlasse(String klassenName) throws KeineKlasse {
        for (Klasse klasse: klassenList) {
            if (klasse.getName().equals(klassenName)){
                return klasse;
            }
        }
        throw new KeineKlasse(klassenName);
    }

    public void addNeuLehrer(Lehrer lehrer) throws PersonExist {
        if (lehrerList.contains(lehrer)) {
            throw new PersonExist(lehrer.getLehrerNummerObje().getLehrerNummer());
        } else {
            lehrerList.add(lehrer);
        }
    }
    public void removeLehrer(Lehrer lehrer) throws KeinPerson {
        if (lehrerList.contains(lehrer)){
            lehrerList.remove(lehrer);
        } else {
            throw new KeinPerson(lehrer.getLehrerNummerObje().getLehrerNummer());
        }
    }
    public void addLehrerInKlasse(String klassenName, String lehrerNummer) throws KeineKlasse, PersonExist, KeinPerson {
        if (getKlasse(klassenName) != null && getLehrer(lehrerNummer) != null && !istLehrerDa(klassenName, lehrerNummer)) {
            getKlasse(klassenName).getLehrers().add(getLehrer(lehrerNummer));
        }
    }
    public void removeLehrerVonKlasse(String klassenName, String lehrerNUmmer) throws KeineKlasse, KeinPerson, PersonExist {
        if (getKlasse(klassenName) != null && getLehrer(lehrerNUmmer) != null && istLehrerDa(klassenName,lehrerNUmmer)) {
            getKlasse(klassenName).getLehrers().remove(getLehrer(lehrerNUmmer));
        }
    }
    private boolean istLehrerDa(String klassenName, String lehrerNummer) throws KeineKlasse, PersonExist {
        if (getKlasse(klassenName) != null) {
            for (Lehrer lehrer: getKlasse(klassenName).getLehrers()) {
                if (lehrer.getLehrerNummerObje().getLehrerNummer().equals(lehrerNummer)){
                    return true;
                }
            }
        } return false;
    }
    public Lehrer getLehrer(String lehrerNummer) throws KeinPerson {
        for(Lehrer lehrer:lehrerList) {
            if (lehrer.getLehrerNummerObje().getLehrerNummer().equals(lehrerNummer)){
                return lehrer;
            }
        }
        throw new KeinPerson(lehrerNummer);
    }



}

