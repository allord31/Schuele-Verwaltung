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

package de.openknowledge.domain.verwaltung.klasse;

import de.openknowledge.domain.verwaltung.attribute.Name;
import de.openknowledge.domain.verwaltung.schueler.Schueler;
import de.openknowledge.domain.verwaltung.lehrer.Lehrer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Klasse {
    private Name name;
    private String Beschreibung;
    private String Stufe;
    private  String Klassenlehrer;
    private ArrayList<Schueler> schuelers = new ArrayList<>();
    private ArrayList<Lehrer> lehrers = new ArrayList<>();

    public Klasse() {
    }

    public Klasse(Name name, String beschreibung, String stufe, String klassenlehrer) {
        this.name = name;
        Beschreibung = beschreibung;
        Stufe = stufe;
        Klassenlehrer = klassenlehrer;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        Beschreibung = beschreibung;
    }

    public String getStufe() {
        return Stufe;
    }

    public void setStufe(String stufe) {
        Stufe = stufe;
    }

    public String getKlassenlehrer() {
        return Klassenlehrer;
    }

    public void setKlassenlehrer(String klassenlehrer) {
        Klassenlehrer = klassenlehrer;
    }

    public ArrayList<Schueler> getSchuelers() {
        return schuelers;
    }
    public void addSchueler(Schueler schueler) {
        this.schuelers.add(schueler);
    }

    public void removeSchueler(Schueler schueler) {
        this.schuelers.remove(schueler);
    }

    public void setSchuelers(ArrayList<Schueler> schuelers) {
        this.schuelers.addAll(schuelers);
    }

    public List<Lehrer> getLehrers() {
        return Collections.unmodifiableList(lehrers);
    }
    public void addLehrer(Lehrer lehrer) {
        this.lehrers.add(lehrer);
    }
    public void removeLehrer(Lehrer lehrer) {
        this.lehrers.remove(lehrer);
    }

    public void setLehrers(ArrayList<Lehrer> lehrers) {
        this.lehrers.addAll(lehrers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Klasse klasse = (Klasse) o;
        return Objects.equals(getName(), klasse.getName()) && Objects.equals(getBeschreibung(), klasse.getBeschreibung()) &&
            Objects.equals(getStufe(), klasse.getStufe()) &&
            Objects.equals(getKlassenlehrer(), klasse.getKlassenlehrer()) &&
            Objects.equals(getSchuelers(), klasse.getSchuelers()) && Objects.equals(getLehrers(), klasse.getLehrers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBeschreibung(), getStufe(), getKlassenlehrer(), getSchuelers(), getLehrers());
    }

    @Override
    public String toString() {
        return "Klasse{" +
            "name='" + name + '\'' +
            ", Beschreibung='" + Beschreibung + '\'' +
            ", Stufe='" + Stufe + '\'' +
            ", Klassenlehrer='" + Klassenlehrer + '\'' +
            ", schuelers=" + schuelers +
            ", lehrers=" + lehrers +
            '}';
    }
}
