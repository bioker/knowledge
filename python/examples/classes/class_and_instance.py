class Test:

    class_variable = "Shared for all instances"
    mutable_class_variable = [] # lists are mutable

    def __init__(self, value):
        self.instance_variable = ("Unique for each instance, "
                "value: {0}").format(value)

    def add_to_class_variable(self, value):
        self.mutable_class_variable.append(value)

t1 = Test("value1")
t2 = Test("value2")

assert t1.instance_variable == "Unique for each instance, value: value1"
assert t2.instance_variable == "Unique for each instance, value: value2"

assert t1.class_variable == "Shared for all instances"

t1.class_variable = "Changed"

# value was added to t1 instance and it's not shared with t2 instance
# because of strings are immutable (only reference of variable can be changed)
# and with statement above we replaced reference of class variable with
# reference of instance variable (class variable is shaded)
assert t2.class_variable == "Shared for all instances"
assert t1.class_variable == "Changed"

t1.add_to_class_variable("value3")

# value was added to t1 instance but now it's shared with t2
# because of list reference wasn't changed (only values in list)
assert len(t2.mutable_class_variable) == 1
assert t2.mutable_class_variable[0] == "value3"
