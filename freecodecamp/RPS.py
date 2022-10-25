import random

def get_choices():
  player_choice = input("Enter the choice : Rock, Paper, Scissors : ")
  options = ["Rock" ,"Paper" ,"Scissors"]
  computer_choice = random.choice(options)
  choices = {"player" : player_choice, "computer" : computer_choice}

  return choices

def check_win(player, computer):
  print(f"You chose {player} ,Computer chose {computer}")
  if player == computer :
    return "It's a tie!"
  elif player == "Rock":
    if computer == "Scissors":
      return "Rock smashes Scissors! You win!"
    else:
      return "Paper covers Rock! You lose!"
  elif player == "Paper":
    if computer == "Rock":
      return "Paper covers Rock! You win!"
    else:
      return "Scissors cuts Paper! You lose!"
  elif player == "Scissors":
    if computer == "Rock":
      return "Rock smashes Scissors! You lose!"
    else:
      return "Scissors cuts Paper! You win!"

choices = get_choices()
result = check_win(choices["player"] ,choices["computer"])
print(result)
