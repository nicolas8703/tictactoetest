public class Game {
    private Board board;
    private int currentPlayer;
    private LanguageManager languageManager;
    private InputHandler inputHandler;
    private boolean gameOver;

    public Game() {
        board = new Board();
        currentPlayer = 1;
        languageManager = new LanguageManager();
        inputHandler = new InputHandler();
        gameOver = false;
    }

    public void start() {
        board.initialize();
        board.display();
        while (!gameOver) {
            handleLanguageSwitch();
            handleTurn();
            board.display();
            checkGameOver();
            if (!gameOver) {
                switchPlayer();
            }
        }
        inputHandler.closeScanner();
    }

    private void handleLanguageSwitch() {
        System.out.println(languageManager.getMessage("askLanguageSwitch"));
        boolean switchLang = inputHandler.getYesNoInput(languageManager.getMessage("yesNoPrompt"));
        if (switchLang) {
            languageManager.switchLanguage();
        }
    }

    private void handleTurn() {
        String playerSymbol = currentPlayer == 1 ? "X" : "O";
        System.out.println(languageManager.getMessage("playerTurn") + " " + currentPlayer + " (" + playerSymbol + ")");
        int row = inputHandler.getIntInput(languageManager.getMessage("enterRow")) - 1;
        int col = inputHandler.getIntInput(languageManager.getMessage("enterCol")) - 1;

        while (!board.makeMove(row, col, playerSymbol.charAt(0))) {
            System.out.println(languageManager.getMessage("invalidMove"));
            row = inputHandler.getIntInput(languageManager.getMessage("enterRow")) - 1;
            col = inputHandler.getIntInput(languageManager.getMessage("enterCol")) - 1;
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
    }

    private void checkGameOver() {
        String playerSymbol = currentPlayer == 1 ? "X" : "O";
        if (board.checkWin(playerSymbol.charAt(0))) {
            System.out.println(languageManager.getMessage("playerWins") + " " + currentPlayer + "!");
            gameOver = true;
        } else if (board.isFull()) {
            System.out.println(languageManager.getMessage("draw"));
            gameOver = true;
        }
    }
}
