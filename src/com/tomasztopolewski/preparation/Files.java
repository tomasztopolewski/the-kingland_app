/****************************************************************************************
 * Klasa ma za zadanie sprawdzić, czy pliki odpowiedzialne za grę istnieją, czy są
 * dobrze poumieszane w folderach. Ma również sprawdzić, czy pliki odpowiedzialne
 * za grę (np. ustawienia, odpowiednie bazy danych - z użytkownikami, królestwami)
 * są poprawnie napisane.
****************************************************************************************/

package com.tomasztopolewski.preparation;

import java.io.File;
import java.nio.file.Path;

public abstract class Files {

    private final static String pathToFolderGame = "C:\\Program Files\\TheKingLand";
    /**** OBJAŚNIENIE STRUKTURY PLIKÓW
     * bin - pliki ustawień gry
     * bin\bas - pliki baz danych
     * cot - pliki o użytkownikach (postęp, rozwój w grze)
     */


    // przechowuje informacje o poprawności struktury plików gry
    private static boolean isAllOkay = false;

    public static boolean isIsAllOkay() {
        return false;
    }



}
