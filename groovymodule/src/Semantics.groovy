import groovy.transform.CompileStatic
import groovy.transform.Immutable
import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer

import java.util.function.Predicate


def d = [10, 20, 'foo']

//def z
//try {
//    def i = 7, j = 0
//    try {
//        def k = i / j
//        assert false        //never reached due to Exception in previous line
//    } finally {
//        z = 'reached here'  //always executed even if Exception thrown
//    }
//} catch ( e ) {
//    assert e in ArithmeticException
//    assert z == 'reached here'
//}

def x = 2
def y = 7
def z = 5
def calc = { a, b -> a * b + 1 }
//assert calc(x,y) == [x,z].sum() :"wrong"
//for (int i=0;i<10;i++) {
//    for (int j=0;j<i;j++) {
//        println "j=$j"
//        if (j == 5) {
//            break exit
//        }
//    }
//    exit: println "i=$i"
//}
interface Predicate<T> {
    boolean accept(T obj)
}

Predicate filter = { it.contains 'G' } as Predicate
println filter.accept('Groovy')

println GroovySystem.getVersion()

interface FooBar {
    int foo()

    void bar()
}

def impl = { println 'ok'; 123 } as FooBar
assert impl.foo() == 123
impl.bar()

@TypeChecked
class Calculator {
    @TypeChecked(TypeCheckingMode.SKIP)
    int sum(int x, int y) { x + y }
}

@groovy.transform.TypeChecked
void flowTyping() {
    def o = 'foo'
    o = o.toUpperCase()
    o = 9d
    o = Math.sqrt(o)
}

flowTyping()
void doSomething(String str, @ClosureParams(FirstParam) groovy.lang.Closure c){
    c(str)
}
doSomething('foo') {println it.capitalize()}

class Computer {
    int compute(String str) {
        str.length()
    }
    String compute(int x) {
        String.valueOf(x)
    }
}

@CompileStatic
void test() {
    def computer = new Computer()
    computer.with {
        assert compute(compute('foobar')) =='6'
    }
}
Computer.metaClass.compute = { String str -> new Date() }
test()

def script = 'robot.move 100'
class Robot{
    Robot move(int qt) {this}
}
def config = new CompilerConfiguration()
config.addCompilationCustomizers(
        new ASTTransformationCustomizer(TypeChecked)
)
//def shell = new GroovyShell(config)
//def robot = new Robot()
//shell.setVariable('robot', robot)
//shell.evaluate(script)

def process = 'dir'.execute()
println "${process.text}"

['a', 'b', 'c'].eachWithIndex { it, i -> // `it` is the current element, while `i` is the index
    println "$i: $it"
}