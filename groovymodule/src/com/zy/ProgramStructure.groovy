package com.zy

import com.thoughtworks.xstream.core.ReferenceByIdMarshaller
import org.multiverse.api.exceptions.PanicError


println "hello"
int x = 1;
int y = 2
assert x + y == 3
power(2)
z = 5

int power(int n) {
    2**n
}

int i = 2
println i.toString()

class Foo {
    static int i
}

assert Foo.class.getDeclaredField('i').type == int.class
assert Foo.i.class != int.class && Foo.i.class == Integer.class

class PersonConstructor {
    String name
    Integer age

    PersonConstructor(name, age) {
        this.name = name
        this.age = age
    }
}

def person1 = new PersonConstructor("张三", 1)
def person2 = ["李四", 2] as PersonConstructor
PersonConstructor person3 = ['王五', 3]
println person3

class Test {
    final int i

    Test(Map map) {
        this.i = map['i'] as int
    }
}

def baz(a = 'a', int b, c = 'c', boolean d, e = 'e') { "$a $b $c $d $e" }

println baz(1, 2, 3, false, false)

def test = new Test(i: 2)

def method(Date d, Object o) { 'd/o' }

def method(Object o, String s) { 'o/s' }

//def ex = shouldFail {
//    println method(new Date(), 'baz')
//}
//assert ex.message.contains('Ambiguous method overloading')

def badRead() throws FileNotFoundException {
    new File('doesNotExist.txt').text
}


class Test1 {
    protected String name
    String name
}

@interface SomeAnnotation {

}

trait A {
    void methodFromA() {}
}

trait B {
    void methodFromB() {}
}

class C {}

def c = new C()
def d = c.withTraits A, B
d.methodFromA()
d.methodFromB()

class T1 {
    def setName(String str) {
        println 2
    }
}

def t = new T1()
t.name = 2

def code = {123}
assert code() == 123
assert code.call() == 123

def magic = {42}
magic.call(1)