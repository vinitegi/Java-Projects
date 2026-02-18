package Sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuFrame extends JFrame {

    private JTextField[][] cells = new JTextField[9][9];
    private SudokuBoard board;

    public SudokuFrame() {

        board = new SudokuBoard();

        setTitle("Sudoku");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Arial", Font.BOLD, 20));

                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        JButton solveButton = new JButton("Resolver");
        solveButton.addActionListener(e -> solveSudoku());

        JButton clearButton = new JButton("Limpar");
        clearButton.addActionListener(e -> clearBoard());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(solveButton);
        buttonPanel.add(clearButton);

        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void solveSudoku() {

        try {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {

                    String text = cells[row][col].getText();

                    if (!text.isEmpty()) {
                        board.setValue(row, col, Integer.parseInt(text));
                    } else {
                        board.setValue(row, col, 0);
                    }
                }
            }

            if (SudokuSolver.solve(board.getBoard())) {

                for (int row = 0; row < 9; row++) {
                    for (int col = 0; col < 9; col++) {
                        cells[row][col].setText(
                                String.valueOf(board.getValue(row, col))
                        );
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Sem solução!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite apenas números de 1 a 9!");
        }
    }

    private void clearBoard() {
        board.clear();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText("");
            }
        }
    }
}
