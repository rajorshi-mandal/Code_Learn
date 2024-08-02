def student(name, age, roll):
    print(name,age,roll)

def isPalindrome(n):
    rev = 0
    temp = n
    while n > 0:
        rev = rev * 10 + n % 10
        n //= 10
    return True if rev == temp else False


def factorial(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

def krishnamurti(n):
    factSum = 0
    temp = n
    while n > 0:
        factSum += factorial(n % 10)
        n //= 10
    return factSum == temp
