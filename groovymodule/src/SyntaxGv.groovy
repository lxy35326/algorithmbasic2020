import java.math.MathContext

//单行注释与别的语言一样
//单行注释
println "hello" //单行注释

/* 多行注释也与别的语言
一样的
*/
/**@
 * some class groovydoc for Foo
 */
class Foo{
    /**@
     * some method groovydoc for bar
     */
    void bar(){
    }

}
println Foo.class.groovydoc.content.contains('some class groovydoc')
println Foo.class.getMethod('bar',new Class[0]).groovydoc.content.
contains('some method')

def "null"(){true}
println this.null()


/*用单引号的是普通的字符串*/
'一个普通的字符串，是普通的java.lang.String，不支持插值'

println 'ab' == 'a' + 'b'
'''你好呀，这是一个用三引号的字符串
也是java.lang.String，不支持插值'''

println "\u20ac"

def name = "Guillaume"
def greeting = "Hello $name"
println greeting

String thing = 'treasure'

assert '$5' == "\$5"


String takeString(String message){
    assert message instanceof String
    return message
}

def message = "The message is ${'hello'}"
assert message instanceof GString

def result = takeString(message)
assert result instanceof String
assert result == "The message is hello"

assert "one${1}".hashCode() != "one1".hashCode()

def template = """
"hello"
"""
println template


def multilineSlashyString=/
one
two
three
/

println multilineSlashyString

char c1 = 'A'
def c2 = 'B' as char
def c3 = (char)'C'
assert c1 instanceof Character
assert c2 instanceof Character
assert c3 instanceof Character

a = true
println a

def numbers = [1,2,3]
assert numbers instanceof List
assert numbers.size() == 3

def heterogeneous = [1,"a",true] as LinkedList

def key = "name"
def person = [key:"zy"]
assert person.containsKey('key')
assert !person.containsKey('name')

person = [(key):"zy"]
assert person.containsKey('name')
assert !person.containsKey('key')

