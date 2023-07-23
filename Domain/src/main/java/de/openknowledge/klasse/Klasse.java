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

package de.openknowledge.klasse;

import de.openknowledge.lehrer.Lehrer;
import de.openknowledge.schueler.Schueler;

import java.util.ArrayList;
import java.util.Objects;

public class Klasse {
    private String name;
    private String Beschreibung;
    private String Stufe;
    private  String Klassenlehrer;
    private ArrayList<Schueler> schuelerGruppe;
    private ArrayList<Lehrer> lehrerGruppe;

    public Klasse() {
    }

    public Klasse(String name, String beschreibung, String stufe, String klassenlehrer) {
        this.name = name;
        Beschreibung = beschreibung;
        Stufe = stufe;
        Klassenlehrer = klassenlehrer;
    }
    public void addSchueler(Schueler schueler) {
        schuelerGruppe.add(schueler);
    }
    public void removeSchueler(Schueler schueler) {
        schuelerGruppe.remove(schueler);
    }
    public ArrayList<Schueler> getSchuelerGruppe() {
        return schuelerGruppe;
    }
    public void addLehrer(Lehrer lehrer) {
        lehrerGruppe.add(lehrer);
    }
    public void removeLehrer(Lehrer lehrer) {
        lehrerGruppe.remove(lehrer);
    }
    public ArrayList<Lehrer> getLehrerGruppe() {
        return lehrerGruppe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
            Objects.equals(getSchuelerGruppe(), klasse.getSchuelerGruppe()) &&
            Objects.equals(getLehrerGruppe(), klasse.getLehrerGruppe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBeschreibung(), getStufe(), getKlassenlehrer(), getSchuelerGruppe(), getLehrerGruppe());
    }

    @Override
    public String toString() {
        return "Klasse{" +
            "name='" + name + '\'' +
            ", Beschreibung='" + Beschreibung + '\'' +
            ", Stufe='" + Stufe + '\'' +
            ", Klassenlehrer='" + Klassenlehrer + '\'' +
            ", schuelerGruppe=" + schuelerGruppe +
            ", lehrerGruppe=" + lehrerGruppe +
            '}';
    }
}
