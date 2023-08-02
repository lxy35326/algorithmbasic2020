def a = 'Bob'
def ages = [a: 43]
assert ages['Bob'] == null
assert ages['a'] == 43

ages = [(a): 43]
assert ages['Bob'] == 43

show = { println it }
square_root = { Math.sqrt(it) }

def please(action) {
    [the: { what ->
        [of: { n -> action(what(n)) }]
    }]
}

def p(action) {
    [
            the : {what -> [of: {n -> action(what(n))}]}
    ]
}

def f = p(1)
// equivalent to: please(show).the(square_root).of(100)
please show the square_root of 100
p show
please(show).the(square_root).of(100)
// ==> 10.0