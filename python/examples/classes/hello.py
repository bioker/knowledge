class Greeter:

    def __init__(self, message):
        self.message = message

    def greet(self, name):
        return self.message.format(name)

hello = Greeter("Hello, {0}!")
good_morning = Greeter("Good morning, {0}!")
assert hello.greet("Viktor") == "Hello, Viktor!"
assert good_morning.greet("Viktor") == "Good morning, Viktor!"

# Alternative for such functional is closure (just for the note)

def greeter(message):
    def greet(name):
        return message.format(name)
    return greet

hi = greeter("Hi, {0}!")
whatsup = greeter("What's up, {0}!")

assert hi("Viktor") == "Hi, Viktor!"
assert whatsup("Viktor") == "What's up, Viktor!"
