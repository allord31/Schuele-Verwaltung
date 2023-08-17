package de.openknowledge.application.controlinterface;
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

import java.util.Locale;
import java.util.ResourceBundle;

import de.openknowledge.application.guiservices.Sprachen;
import de.openknowledge.infrastruktur.printing.MyBufferedReader;

import org.apache.log4j.Logger;

public class MainInterface {
    private static ResourceBundle resourceBundle = new Sprachen().getResourceBundle();

    public static void mainInterfaceZeigen() {
        MyBufferedReader.print("\n" + resourceBundle.getString("hauptMenu"));    }
    public static void setResourceBundle(ResourceBundle setResourceBundle) {
        resourceBundle = setResourceBundle;
    }

    public static String mainInterfaceRueckGeben() {
        return resourceBundle.getString("hauptMenu");
    }

    public static void wasWollenSieZeigen() {
        MyBufferedReader.print("\n" + resourceBundle.getString("WAS_WOLLEN_SIE_ZEIGEN"));
    }

    public static void wasUmsetzen() {
        MyBufferedReader.print("\n" + resourceBundle.getString("WAS_UMSETZEN"));
    }

    public static void wasAddieren() {
        MyBufferedReader.print("\n" + resourceBundle.getString("WAS_WOLLEN_SIE_ADDIEREN"));
    }

    public static void wasEntfernen() {
        MyBufferedReader.print("\n" + resourceBundle.getString("WAS_WOLLEN_SIE_ENTFERNEN"));
    }
}
