# 🧩 Sudoku Console Game

 Este é um jogo de Sudoku implementado em Java para ser jogado no terminal. Ele foi construído utilizando uma estrutura modular, organizada em packages (model, util, main), com validações de preenchimento, exibição visual do tabuleiro e controle de estado do jogo.

# 🕹️ Funcionalidades
 ✅ Iniciar um novo jogo com valores fixos

🔢 Inserir valores nas posições livres

❌ Remover números inseridos

👁️ Visualizar o estado atual do tabuleiro com layout gráfico

📊 Verificar status do jogo (não iniciado, incompleto, completo) e presença de erros

🔄 Limpar o jogo atual

🏁 Finalizar o jogo se estiver corretamente preenchido

# 🧱 Board e Space

- Board mantém a estrutura de 9x9 células e contém métodos de controle como changeValue, clearValue, hasErrors e gameIsFinished.

- Space representa uma célula do tabuleiro com valor atual (actual), valor esperado (expected) e se é uma posição fixa (fixed).

# 🖼️ Layout Visual
A classe BoardTemplate define um layout ASCII completo para exibição formatada do tabuleiro, permitindo visualizar claramente cada célula com ou sem preenchimento.

# 📌 Requisitos
- Java 17 ou superior
