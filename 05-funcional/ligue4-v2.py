from copy import deepcopy


def create_grid():
    return [[0] * 7 for _ in range(6)]


def create_scores():
    return {"player1": 0, "player2": 0, "ties": 0}


def switch_turn(current_turn):
    return 2 if current_turn == 1 else 1


grid = create_grid()
scores = create_scores()
current_turn = 1
game_active = True


def update_score(scores, winner):
    new_scores = deepcopy(scores)
    if winner == "player1":
        new_scores["player1"] += 1
    elif winner == "player2":
        new_scores["player2"] += 1
    else:
        new_scores["ties"] += 1
    return new_scores


def desistance(current_turn, scores):
    print(f" {current_turn} loses by desistance")
    if current_turn == 1:
        return update_score(scores, "player2")
    else:
        return update_score(scores, "player1")


def play_input(user_input, grid, current_turn):
    user_input = int(user_input)
    if 1 <= user_input <= 7:
        valid_choice = False
        for row in range(5, -1, -1):
            if grid[row][user_input - 1] == 0:
                grid[row][user_input - 1] = current_turn
                valid_choice = True
                break
        if not valid_choice:
            print("\nColumn is full! Choose another one.\n")
            grid, current_turn = play_input(input("Which column? "), grid, current_turn)
        current_turn = switch_turn(current_turn)
    else:
        print("\nInvalid column! Choose between 1 and 7.\n")
    return grid, current_turn


def process_input(grid, current_turn, scores):
    game_active = True
    user_input = input("Which column? ")

    if user_input == "d":
        scores = desistance(current_turn, scores)
        return grid, switch_turn(current_turn), scores, False
    elif user_input.isdigit() and 1 <= int(user_input) <= 7:
        grid, current_turn = play_input(user_input, grid, current_turn)
        scores, current_turn, game_active = check_win(
            grid, scores, current_turn, game_active
        )
    else:
        print("\nInvalid input! Try again.")
        return grid, current_turn, scores, True

    return grid, current_turn, scores, game_active


def print_game(grid):
    for row in grid:
        print(
            "|"
            + "|".join(" " if cell == 0 else "x" if cell == 1 else "o" for cell in row)
            + "|"
        )
    print()


def end_game(current_turn):
    if current_turn == 0:
        print("It's a tie!")
    else:
        print(f"Player {current_turn} wins!")


def check_win(grid, scores, current_turn, game_active):
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
        scores = update_score(scores, "ties")
        current_turn = 0
        game_active = False
    elif winner == 1:
        scores = update_score(scores, "player1")
        game_active = False
    elif winner == 2:
        scores = update_score(scores, "player2")
        game_active = False

    return scores, current_turn, game_active


def print_scores(scores):
    print("\n----- Scoreboard -----")
    print(f"Player 1 (x): {scores['player1']}")
    print(f"Player 2 (o): {scores['player2']}")
    print(f"Ties: {scores['ties']}")
    print("----------------------\n")


def restart_prompt():
    restart_choice = input("Do you wanna play another round? [y/n]")
    return restart_choice.lower() == "y"


def run_game():
    grid = create_grid()
    scores = create_scores()
    current_turn = 1
    game_active = True

    while game_active:
        print_game(grid)
        print_scores(scores)
        grid, current_turn, scores, game_active = process_input(
            grid, current_turn, scores
        )

        if not game_active:
            print_game(grid)
            print_scores(scores)
            if restart_prompt():
                grid = create_grid()
                current_turn = 1
                game_active = True
            else:
                print("Thanks for playing!")
                break


run_game()
