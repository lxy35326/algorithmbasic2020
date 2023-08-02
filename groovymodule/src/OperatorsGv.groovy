import java.util.regex.Matcher
import java.util.regex.Pattern

assert +3 == 3
assert -4 == 0 - 4
assert -(-1) == 1

def a = 2
def b = a++ * 3
assert a == 3 && b == 6

class User{
    public final String name
    User(String name){
        this.name = name
    }
    String getName(){
        "Name: $name"
    }
}

def user = new User('Bob')
println user.name
println user.@name

def str = /example of method reference /
def fun = str.&toUpperCase
def upper = fun()
assert upper == str.toUpperCase()

def pattern = ~/foo/
assert pattern instanceof Pattern

def text = "some text to match"
def m = text =~ /\w+/
assert m instanceof Matcher
while (m.find()) {
    println m.group()
}

def range = 0..5
assert range instanceof List
println 'a'.previous()

class People{
    Long id
    String name
    def getAt(int i) {
        switch (i) {
            case 0: return id
            case 1: return name
        }
        throw new IllegalArgumentException("No such element $i")
    }

    def putAt(int i, def value){
        switch (i) {
            case 0: id = value; return
            case 1: name = value; return
        }
        throw new IllegalArgumentException("No such element $i")
    }

}

def people = new People(id : 1,name: 'Alex')
assert people[0] == 1
assert people[1] == 'Alex'
people[1] = 'Bob'
assert people.@name == "Bob"

def list = ['Grace']
assert ('Grace' in list)
assert list.isCase('''Grace''')

Integer x = 123
String s = (String)x
println s