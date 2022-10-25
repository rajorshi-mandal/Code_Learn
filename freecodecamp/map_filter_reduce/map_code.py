# map(), filter(), reduce()

numbers = [1, 2, 3]

double = lambda a : a * 2
#def double(a):
  #return a * 2

  #result = map(lambda a : a * 2, numbers)
  result = map(double, numbers)

  print(list(result))
