# Accepting Arguments
import argparse

parser = argparse.ArgumentParser(
  description = 'This program prints the output I provide in the shell'
)

parser.add_argument('-c', '--color', metavar = 'color', required = True, help = 'the color to search for')

args = parser.parse_args()

print(args.color)
