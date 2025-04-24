package br.com.dio.main;

import br.com.dio.model.Board;
import br.com.dio.model.Space;

import java.util.*;
import java.util.stream.*;

import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));

        while (true){
            showMenu();
            int option = scanner.nextInt();
            handleMenuOption(option, positions);
        }
    }

    private static void showMenu() {
        System.out.println("Selecione uma das opções a seguir");
        System.out.println("1 - Iniciar um novo Jogo");
        System.out.println("2 - Colocar um novo número");
        System.out.println("3 - Remover um número");
        System.out.println("4 - Visualizar jogo atual");
        System.out.println("5 - Verificar status do jogo");
        System.out.println("6 - Limpar jogo");
        System.out.println("7 - Finalizar jogo");
        System.out.println("8 - Sair");
    }

    private static void handleMenuOption(int option, Map<String, String> positions) {
        switch (option) {
            case 1 -> startGame(positions);
            case 2 -> inputNumber();
            case 3 -> removeNumber();
            case 4 -> showCurrentGame();
            case 5 -> showGameStatus();
            case 6 -> clearGame();
            case 7 -> finishGame();
            case 8 -> System.exit(0);
            default -> System.out.println("Opção inválida, selecione uma das opções do menu");
        }
    }

    private static void startGame(Map<String, String> positions) {
        if (board != null) {
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                spaces.get(i).add(new Space(expected, fixed));
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar");
    }

    private static void inputNumber() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Informe a coluna (0-8):");
        var col = getValidNumber(0, 8);
        System.out.println("Informe a linha (0-8):");
        var row = getValidNumber(0, 8);
        System.out.printf("Informe o número para a posição [%s,%s]:\n", col, row);
        var value = getValidNumber(1, 9);

        if (!board.changeValue(col, row, value)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo.\n", col, row);
        }
    }

    private static void removeNumber() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Informe a coluna (0-8):");
        var col = getValidNumber(0, 8);
        System.out.println("Informe a linha (0-8):");
        var row = getValidNumber(0, 8);

        if (!board.clearValue(col, row)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo.\n", col, row);
        }
    }

    private static void showCurrentGame() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        var args = new Object[81];
        var argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var col : board.getSpaces()) {
                args[argPos++] = " " + (col.get(i).getActual() == null ? " " : col.get(i).getActual());
            }
        }

        System.out.println("Seu jogo se encontra da seguinte forma:");
        System.out.printf((BOARD_TEMPLATE) + "\n", args);
    }

    private static void showGameStatus() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.printf("O jogo atualmente se encontra no status %s\n", board.getStatus().getLabel());
        System.out.println(board.hasErrors() ? "O jogo contém erros" : "O jogo não contém erros");
    }

    private static void clearGame() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Tem certeza que deseja limpar seu jogo e perder todo seu progresso? (sim/não)");
        var confirm = scanner.next();
        if (confirm.equalsIgnoreCase("sim")) {
            board.reset();
        }
    }

    private static void finishGame() {
        if (board == null) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        if (board.gameIsFinished()) {
            System.out.println("Parabéns, você concluiu o jogo!");
            showCurrentGame();
            board = null;
        } else {
            System.out.println("O jogo ainda não foi finalizado.");
        }
    }

    private static int getValidNumber(final int min, final int max) {
        var current = scanner.nextInt();
        while (current < min || current > max) {
            System.out.printf("Informe um número entre %s e %s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }
}
