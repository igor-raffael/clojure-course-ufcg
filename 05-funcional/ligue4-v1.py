grid = [[0] * 7 for _ in range(6)]
scores = {"player1": 0, "player2": 0, "ties": 0}
current_turn = 1
game_active = True

while True:
    while True:
        print("|1|2|3|4|5|6|7|")
        for row in grid:
            print(
                "|"
                + "|".join(
                    " " if cell == 0 else "x" if cell == 1 else "o" for cell in row
                )
                + "|"
            )
        print()

        if not game_active:
            if current_turn == 0:
                print("It's a tie!")
            else:
                current_turn = 2 if current_turn == 1 else 1
                print(f"Player {current_turn} wins!")
            break

        column_choice = input("Which column? ")

        if column_choice == "d":
            print(f" {current_turn} loses by desistance")
            if current_turn == 1:
                scores["player2"] += 1
            else:
                scores["player1"] += 1
            game_active = False
            break

        if column_choice.isdigit():
            column_choice = int(column_choice)
            if 1 <= column_choice <= 7:
                valid_choice = False
                for row in range(5, -1, -1):
                    if grid[row][column_choice - 1] == 0:
                        grid[row][column_choice - 1] = current_turn
                        valid_choice = True
                        break
                if not valid_choice:
                    print("\nColumn is full! Choose another one.\n")
                    continue
                current_turn = 2 if current_turn == 1 else 1
            else:
                print("\nInvalid column! Choose between 1 and 7.\n")
        else:
            print("\nInvalid input! Enter a number or 'd' to quit\n")

        winner = None

        for row in grid:
            for col in range(4):
                if row[col] == row[col + 1] == row[col + 2] == row[col + 3] != 0:
                    winner = row[col]

        for col in range(7):
            for row in range(3):
                if (
                    grid[row][col]
                    == grid[row + 1][col]
                    == grid[row + 2][col]
                    == grid[row + 3][col]
                    != 0
                ):
                    winner = grid[row][col]

        for row in range(3, 6):
            for col in range(4):
                if (
                    grid[row][col]
                    == grid[row - 1][col + 1]
                    == grid[row - 2][col + 2]
                    == grid[row - 3][col + 3]
                    != 0
                ):
                    winner = grid[row][col]

        for row in range(3):
            for col in range(4):
                if (
                    grid[row][col]
                    == grid[row + 1][col + 1]
                    == grid[row + 2][col + 2]
                    == grid[row + 3][col + 3]
                    != 0
                ):
                    winner = grid[row][col]

        empty_spaces = sum(row.count(0) for row in grid)

        if winner is None and empty_spaces <= 0:
            scores["ties"] += 1
            current_turn = 0
            game_active = False
        elif winner == 1:
            scores["player1"] += 1
            game_active = False
        elif winner == 2:
            scores["player2"] += 1
            game_active = False

    print("\n----- Scoreboard -----")
    print(f"Player 1 (x): {scores['player1']}")
    print(f"Player 2 (o): {scores['player2']}")
    print(f"Ties: {scores['ties']}")
    print("----------------------\n")

    restart_choice = input("Do you wanna play another round? [y/n]")
    if restart_choice == "y":
        grid = [[0] * 7 for _ in range(6)]
        current_turn = 1
        game_active = True
        continue
    elif restart_choice == "n":
        break
