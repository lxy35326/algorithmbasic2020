class Enclosing{
    void run(){
        def whatIsThisObject = {getThisObject()}
        assert whatIsThisObject() == this
        def whatIsThis = {this}
        assert whatIsThis() == this
    }
}

class EnclosingInInnerClass{
    class Inner{
        Closure cl = {this}
    }
    void run(){
        def inner = new Inner()
        assert inner.cl() == inner
    }
}

class Person{
    String name
}

class Thing{
    String name
}

def p = new Person(name:'Norman')
def t = new Thing(name: 'Teapot')

def upperCaseName = {delegate.name.toUpperCase()}
upperCaseName.delegate = p
assert upperCaseName() == 'NORMAN'
upperCaseName.delegate = t
assert upperCaseName() == 'TEAPOT'


def nCopies = {int n,String str -> str * n}
def twice = nCopies.curry(2)
assert twice('bla') == 'blabla'
assert twice('abc') == nCopies(2,'abc')
def fib
fib = { long n -> n<2?n:fib(n-1)+fib(n-2) }.memoize()
//assert fib(25) == 75025 // fast!


//Method pointer operator
def str = "example of method reference"
def fun = str.&toUpperCase
def upper = fun()
assert upper == str.toUpperCase()