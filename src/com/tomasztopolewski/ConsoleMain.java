/****************************************************************************************
 * Klasa programistyczna przeznaczona do testów pojedyńczych klas, bądź funkcji klas.
 * W przyszłości posłuży jako element koorydnujący konsolę gry - jako element
 * dopuszczający ingerencje w grę od wewnątrz.
****************************************************************************************/

package com.tomasztopolewski;

import com.tomasztopolewski.preparation.Installation;
import java.io.IOException;

public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        if (new Installation().isIsOkay()) System.out.println("I get it!");
    }
}
