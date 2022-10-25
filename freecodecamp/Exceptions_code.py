# Exceptions

try:
      result = 2 / 0
except ZeroDivisionError:
      print('Cannot be divided by zero!')
finally:
      result = 1

      print(result) #1

      raise Exception('An Error') #generates an error(intentional)

  try:
        raise Exception('An Error')
    except Exception as error:
          print(error)

          class PageNotFoundException(Exception):
                print('inside')
                  pass #means nothing, empty code

              try:
                    raise PageNotFoundException()
                except PageNotFoundException:
                      print('Page not found!')

                      # with

                      #filename = '/Users/flavio/test.txt'

                      #with open(filename, 'r') as file:
                        #content = file.read()
                          #print(content)
