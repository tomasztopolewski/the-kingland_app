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

    public final static String pathToFolderGame = "C:\\Program Files\\TheKingLand\\";
    /**** OBJAŚNIENIE STRUKTURY PLIKÓW
     * bin - pliki ustawień gry
     * bin\cort - pliki związane z graczem
     */

    public final static String nameFilePlayers = "plys";
    public final static String extensionFilePlayers = "kingfile";
    public final static String pathFilePlayers = "bin\\";
    public final static String defaultContentFilePlayers = "player0:00;";

    public final static String nameFileGameplays = "corts";
    public final static String extensionFileGameplays = "kingfile";
    public final static String pathFileGameplays = "bin\\";
    public final static String defaultContentFileGameplays = "00:00000;";

    public final static String nameFileZeroGameplay = "00000";
    public final static String extensionFileZeroGameplay = "kingfile";
    public final static String pathFileZeroGameplay = "bin\\cort\\";
    public final static String defaultContentFileZeroGameplay = "//defaultowa zawartość pliku";


}
