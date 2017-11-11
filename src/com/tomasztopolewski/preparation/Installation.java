/****************************************************************************************
 * Klasa przeprowadza instalację, gdy pliki gry podczas uruchamiania są niepoprawne
 * lub nie można ich sprawdzić.
 ****************************************************************************************/
package com.tomasztopolewski.preparation;
/*
//Stary obraz klas.
//Nowy zakłada prawidłowe istnienie.

        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;

        public abstract class Installation {

            public final static String pathToFolderGame = "C:\\Program Files\\TheKingLand\\";

            private static String nameFilePlayers = "players";
            private static String extensionFilePlayers = "kingfile";
            private static String pathFilePlayers = "";
            private static String defaultContentFilePlayers = "player0:00;";
            @Deprecated
            private static FileWriter fileWriterPlayers;
            File filePlayers;

            private static String nameFileGameplays = "gameplays";
            private static String extensionFileGameplays = "kingfile";
            private static String pathFileGameplays = "";
            private static String defaultContentFileGameplays = "00:00000;";
            @Deprecated
            private static FileWriter fileWriterGameplays;
            File fileWriterGameplays;

            private static String nameFileZeroGameplay = "00000";
            private static String extensionFileZeroGameplay = "kingfile";
            private static String pathFileZeroGameplay = "gameplays\\";
            private static String defaultContentFileZeroGameplay = "//defaultowa zawartość pliku";
            @Deprecated
            private static FileWriter fileWriterZeroGameplay;
            File fileWriterPlayers;


            static {
                try {
                    fileWriterZeroGameplay = new FileWriter(pathToFolderGame + pathFileZeroGameplay + nameFileZeroGameplay + "." + extensionFileZeroGameplay);
                    fileWriterGameplays = new FileWriter(pathToFolderGame + pathFileGameplays + nameFileGameplays + "." + extensionFileGameplays);
                    fileWriterPlayers = new FileWriter(pathToFolderGame + pathFilePlayers + nameFilePlayers + "." + extensionFilePlayers);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            protected Installation() throws IOException {}

            public static void createFiles() throws IOException {
                try {
                    fileWriterPlayers.write(defaultContentFilePlayers);
                    fileWriterGameplays.write(defaultContentFileGameplays);
                    fileWriterZeroGameplay.write(defaultContentFileZeroGameplay);
                } catch (NullPointerException nullPointerException) {
                    File filePlayers = new File(pathToFolderGame + pathFileZeroGameplay + nameFileZeroGameplay + "." + extensionFileZeroGameplay);
                    File fileWriterGameplays = new File(pathToFolderGame + pathFileGameplays + nameFileGameplays + "." + extensionFileGameplays);
                    File fileWriterPlayers = new File(pathToFolderGame + pathFilePlayers + nameFilePlayers + "." + extensionFilePlayers);
                }
            }
        }
*/


/****************************************************************************************
 * Klasa sprawdza istnienie plików gry i możliwość ich odczytu przez aplikację.
 * Klasa wykorzystywana jako klasa anonimowa.
 *
 * TO-DO:
 *      a. sprawdzanie poprawności treści plików od strony logicznej:
 *          + czy wszystkie id graczy mają przyporządkowane pliki z zapisem postępów
 *          + czy nazwy są poprawnie sformatowane
 *      b.  możliwość odczytu wartości plików i ich przetworzenia (tylko badanie
 *          możliwości wykonania operacji, a nie ich wykonywanie)
 *
 ****************************************************************************************/

import java.io.File;

public class Installation {

    //private Files files;
    //File filePlayers = new File(Files.pathToFolderGame + Files.pathFileZeroGameplay + Files.nameFileZeroGameplay + "." + Files.extensionFileZeroGameplay);
    //File fileWriterGameplays = new File(Files.pathToFolderGame + Files.pathFileGameplays + Files.nameFileGameplays + "." + Files.extensionFileGameplays);
    //File fileWriterPlayers = new File(Files.pathToFolderGame + Files.pathFilePlayers + Files.nameFilePlayers + "." + Files.extensionFilePlayers);

    // przechowuje informacje o poprawności struktury plików gry
    //private static boolean isAllOkay = false;

    public boolean isIsOkay() {
        return new File(Files.pathToFolderGame + Files.pathFileZeroGameplay + Files.nameFileZeroGameplay + "." + Files.extensionFileZeroGameplay).canRead()
                && new File(Files.pathToFolderGame + Files.pathFileGameplays + Files.nameFileGameplays + "." + Files.extensionFileGameplays).canRead()
                && new File(Files.pathToFolderGame + Files.pathFilePlayers + Files.nameFilePlayers + "." + Files.extensionFilePlayers).canRead();
    }
}
