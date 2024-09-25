import java.util.HashMap;
import java.util.Map;

public class LanguageManager {
    private String currentLanguage;
    private Map<String, String> messagesEN;
    private Map<String, String> messagesDE;

    public LanguageManager() {
        currentLanguage = "EN";
        loadMessages();
    }

    public void switchLanguage() {
        currentLanguage = currentLanguage.equals("EN") ? "DE" : "EN";
    }

    public String getMessage(String key) {
        if (currentLanguage.equals("EN")) {
            return messagesEN.get(key);
        } else {
            return messagesDE.get(key);
        }
    }

    private void loadMessages() {
        messagesEN = new HashMap<>();
        messagesDE = new HashMap<>();

        // Englische Nachrichten
        messagesEN.put("playerTurn", "Player's turn:");
        messagesEN.put("enterRow", "Enter row (1-3):");
        messagesEN.put("enterCol", "Enter column (1-3):");
        messagesEN.put("invalidMove", "Invalid move. Try again.");
        messagesEN.put("playerWins", "Player wins");
        messagesEN.put("draw", "It's a draw!");
        messagesEN.put("askLanguageSwitch", "Do you want to switch the language?");
        messagesEN.put("yesNoPrompt", "Enter 'Y' for Yes or 'N' for No:");

        // Deutsche Nachrichten
        messagesDE.put("playerTurn", "Spieler am Zug:");
        messagesDE.put("enterRow", "Zeile eingeben (1-3):");
        messagesDE.put("enterCol", "Spalte eingeben (1-3):");
        messagesDE.put("invalidMove", "Ungültiger Zug. Versuche es erneut.");
        messagesDE.put("playerWins", "Spieler gewinnt");
        messagesDE.put("draw", "Unentschieden!");
        messagesDE.put("askLanguageSwitch", "Möchten Sie die Sprache wechseln?");
        messagesDE.put("yesNoPrompt", "Geben Sie 'J' für Ja oder 'N' für Nein ein:");
    }
}
