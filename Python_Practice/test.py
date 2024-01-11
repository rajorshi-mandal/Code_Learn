print("Hello World !!")

#variables
x = 5
y = "Ayeshee"

print(x)
print(y)

#casting
s = str(3)
i = int(3)
f = float(3)

#comparision operators
print("\n***Comparision Operators***\n")

a = 23
r = 24

print("Addition : ", a + r)
print("Subtraction : ",a - r)
print("Multiplication : ", a * r)
print("Division : ", a/r)
print("Reminder : ", a%r)
print("Exponent : ",a ** r)
print("Floor Division : ", a//r)

#Assignment Operators
print("\n***Assignment Operators***\n")
a = 5
b = 6

print('a=b:', a==b)
print('a+=b:', a+b)
print('a-=b:', a-b)
print('a*=b:',a*b)
print('a%=b:',a%b)
print('a**=b:',a**b)
print('a//=b:',a//b)

#Bitwise Operators
print('\n***Bitwise Operators***\n')

print('a&b:',a&b)
print('a|b:',a|b)
print('a^b:',a^b)
print('~a:',~a)
print('a<<b:',a<<b)
print('a>>b',a>>b)

#Logical operators
print('\n***Logical Operators***\n')

print('Is this statement true?:',a > 3 and a < 5)
print('Any one statement is true:',a > 3 or a < 5)
print('Each statement is true then return false and vice-versa:', (not(a > 3 and a < 5)))

#Membership Operators
print('\n***Identity Operators***\n')
x = ['Rajorshi', 'Ayeshee']
print('Is value Present?', "Rajorshi" in x)
print('Is value not Present?', "Ayeshee" not in x)  

#Identity operators
a = ["Rajorshi", "Ayeshee"]  
b = ["Rajorshi", "Ayeshee"]  
c = a  
print(a is c)  
print(a is not c)  
print(a is b)  
print(a is not b)  
print(a == b)  
print(a != b) 


#Strings
print("\n***String***\n")

print('\nStrings indexing and splitting\n')

str = 'python'

print(type(str))

print(str[0])
print(str[1])
print(str[2])
print(str[3])
print(str[4])
print(str[5])

print(str[0:])
print(str[2:5])
print(str[:5])

print(str[-1])
print(str[-3])
print(str[-2])
print(str[-4:-1])
print(str[-7:-2])

#reversing the given string
print(str[::-1])
