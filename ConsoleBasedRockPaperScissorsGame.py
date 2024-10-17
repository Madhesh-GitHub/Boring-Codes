rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''

import random
images= [rock,paper,scissors]
user_choice = int(input("What do you choose? Type 0 for Rock, 1 for Paper or 2 for Scissors.\n"))
print("You choose:\n\n", images[user_choice])
computer_choice = random.randint(0,2)
print(f"Computer choose:\n\n{images[computer_choice]}")

if user_choice == 0  and computer_choice == 1:
    print("You lost")
elif user_choice == 0  and computer_choice == 2:
    print("You won")
elif user_choice == 1 and computer_choice == 0:
    print("You won!")
elif user_choice == 1  and computer_choice == 2:
    print("You lost")
elif user_choice == 2  and computer_choice == 1:
    print("You won")
elif user_choice == 2  and computer_choice == 0:
    print("You lost")
elif user_choice == computer_choice:
    print("Match draw")
else:
    print("You typed an invalid number, You lost!")
