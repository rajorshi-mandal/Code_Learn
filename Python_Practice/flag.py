import turtle

def draw_rectangle(color, x, y, width, height):
    turtle.penup()
    turtle.goto(x, y)
    turtle.pendown()
    turtle.color(color)
    turtle.begin_fill()
    for _ in range(2):
        turtle.forward(width)
        turtle.right(90)
        turtle.forward(height)
        turtle.right(90)
    turtle.end_fill()

def draw_ashoka_chakra(x, y, radius):
    turtle.penup()
    turtle.goto(x, y - radius)
    turtle.pendown()
    turtle.color("navy")
    turtle.circle(radius)
    for i in range(24):
        turtle.penup()
        turtle.goto(x, y)
        turtle.right(15)
        turtle.pendown()
        turtle.forward(radius)
        turtle.penup()
        turtle.goto(x, y)
        turtle.backward(radius)

def main():
    turtle.speed(0)
    turtle.setup(800, 600)
    
    # Draw the top orange rectangle
    draw_rectangle("orange", -200, 100, 400, 100)
    
    # Draw the middle white rectangle
    draw_rectangle("white", -200, 0, 400, 100)
    
    # Draw the bottom green rectangle
    draw_rectangle("green", -200, -100, 400, 100)
    
    # Draw the Ashoka Chakra
    draw_ashoka_chakra(0, 50, 30)

    turtle.hideturtle()
    turtle.done()

if __name__ == "__main__":
    main()
