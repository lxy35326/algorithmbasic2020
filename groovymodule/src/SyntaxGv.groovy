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

String thing = "treasure"

