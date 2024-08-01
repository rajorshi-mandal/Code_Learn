import turtle

# Set up the screen
screen = turtle.Screen()
screen.bgcolor("sky blue")

# Create the turtle for the sun
sun = turtle.Turtle()
sun.shape("circle")
sun.color("yellow")

# Draw the sun's body
sun.penup()
sun.goto(0, -50)
sun.pendown()
sun.begin_fill()
sun.circle(100)
sun.end_fill()

# Draw the sun's rays
sun.penup()
sun.goto(0, 0)
sun.pendown()
sun.pensize(3)
for _ in range(12):
    sun.forward(150)
    sun.backward(150)
    sun.right(30)

# Hide the turtle
sun.hideturtle()

# Finish up
turtle.done()
