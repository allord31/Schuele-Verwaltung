package de.openknowledge.schueler;/*
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

import de.openknowledge.lehrer.Lehrer;
import de.openknowledge.person.Person;
import de.openknowledge.person.PersonList;
import de.openknowledge.printing.MyBufferedReader;

import java.util.ArrayList;

public class SchuelerList extends PersonList {
    public SchuelerList(){
        super();
    }

    public void removeSchuelerDurchSchulerNum(String schuelerNummer){
        for (Person person: personList) {
            if (((Schueler)person).getSchuelerNummer().equals(schuelerNummer)){
                personList.remove(person);
                return;
            }
        }
        MyBufferedReader.print("Es gibt Kein Lehrer, hat Diese Nummer: " +schuelerNummer);
    }

    public Person schuelerZeigenDurchSchuelerNum(String schuelerNummer) {
        for (Person person: personList) {
            if (((Schueler)person).getSchuelerNummer().equals(schuelerNummer)){
                return  person;
            }
        }
        return null;
    }
    public ArrayList<Person> getSchuelerList() {
        return getPersonList();
    }

}
