class Parent:
    def method_one(self):
        return "super method one"
    def method_two(self):
        return "super method two"
    def method_three(self):
        return "super method three"
class Child(Parent):
    def method_one(self):
        return "overriden method one"
    def method_two(self):
        return "overriden method two with calling: " + Parent.method_two(self)

child = Child()

assert child.method_one() == "overriden method one"
assert child.method_two() == "overriden method two with calling: super method two"
assert child.method_three() == "super method three"

assert isinstance(child, Child)
assert isinstance(child, Parent)
assert issubclass(Child, Parent)
assert not issubclass(Parent, Child)
